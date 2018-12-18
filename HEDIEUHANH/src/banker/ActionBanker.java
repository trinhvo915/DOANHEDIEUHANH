package banker;

import java.util.Random;

import mode.DataBase;
import mode.Data;

public class ActionBanker implements FunctionBanker{	
	private Data data = new Data();
	DataBase database = new DataBase();
	@Override
	public void CreateData() {
		Random random = new Random();
		int q = random.nextInt(10) +1;
		data.setQ(q);
		System.out.println("SỐ TIẾN TRÌNH  Q : "+q);
		int p = random.nextInt(10) +1;
		System.out.println("SỐ TÀI NGUYÊN  P : "+p);
		data.setP(p);
		// Khoi tao bang Max
		int[][] maMax = new int[q][p];
		for(int i = 0 ; i < q; i++) {
			for(int j = 0 ; j < p; j++) {
				maMax[i][j] = random.nextInt(10);
				//System.out.print(maMax[i][j] +"  ");
			}
		}
		data.setMax(maMax);
		// ******************************************************//
		boolean checkMax = database.luuFileTableMax(maMax, q, p);
		// ******************************************************//
		//System.out.println(" Kiem tra : "+check);
		// =============== END ==================//
		// Khoi tao bang Allocation voi dieu kien Allocation [i][j] < Max[i][j]//
		int [][] Allo = new int[q][p];
		for(int i = 0; i < q ; i++) {
			for(int j = 0 ; j <  p ; j++) {
				do {
					Allo[i][j] = random.nextInt(10);
				}while(Allo[i][j] > maMax[i][j]);
				
			}
			
		}
		data.setAllocation(Allo);
		// ******************************************************//
		boolean checkAllo = database.luuFileTableAllocation(Allo,q,p);
		////////////////////////////////////////////////////////////////
		// ************************Available******************************//
		int [] Avai = new int[p];
		for(int i = 0 ; i < p ; i++) {
			Avai[i] = random.nextInt(10);
		}
		data.setAvailable(Avai);
		boolean checkAvailable = database.luuFileTableAvailable(Avai,p);
		// =========== NEED ================= //
		int need [][] = new int [q][p];
		for(int i = 0 ; i < q; i++) {
			for(int j = 0; j < p ; j++) {
				need[i][j] = maMax[i][j] - Allo[i][j];
			}
		}
		data.setNeed(need);

		// ******************************************************//
		boolean checkNeed = database.luuFileTableNeed(need, q, p);
		// ******************************************************//
	}

	@Override
	public void PrintData() {
		data.printTableMax();
		data.printTableAllo();
		data.printTableAvai();
		data.printTableNeed();
	}

	@Override
	public void Update_Q(int k) {
		int q = data.getQ();
		int p = data.getP();
		// ======================================//
		int arr [] = new int[p];
		arr = data.getAvailable();
		// ======================================//
		int arrAllocation[][] = new int [q][p];
		arrAllocation = data.getAllocation();
		// ======================================//
		for (int j = 0; j < p; j++) {
			arr[j] += arrAllocation[k][j]; 
		}
		// ******************************************************//
		boolean checkListAvai = database.luuFileTableListAvailable(arr,p,k);
		// ******************************************************//
		data.setAvailable(arr);

	}

	@Override
	public void RunProcessor() {
		// ================ Get Data ===============//
		ActionBanker actionBanker = new ActionBanker();
		int q = data.getQ();
		int p = data.getP();
		int arrNeed[][] = new int [q][p];
		arrNeed = data.getNeed();
		int arr [] = new int[p];
		// ========== THUAT TOAN KIEM TRA TRANG THAI AN TOAN ===============//
		boolean danhDau[] = new boolean[10];
		for (int i = 0; i < q; i++) {
			danhDau[i] = false;
		}
		boolean check = true;
		while (check) {

			for (int i = 0; i < q; i++) {
				arr = data.getAvailable();
				if (danhDau[i] == false) {
					boolean kt = true;
					for (int j = 0; j < p; j++) {
						if (arrNeed[i][j] > arr[j]) {
							kt = false;
						}
					}
					if (kt == true) {
						System.out.println("=========Khởi chạy tiến trình Q[" + (i +1) + "]============");
						actionBanker.Update_Q(i);
						System.out.println();
						data.printTableAvai();
						System.out.println();
						danhDau[i] = true;
						i = -1;
						//break;
					}

				}

			}
			check = false;
		}
		boolean t = true;
		for (int i = 0 ; i < q;i++) {
			if (danhDau[i] == false) {
				t = false;
			}
		}
		if (t) {
			boolean checkresult= database.luuFileResult("HỆ THỐNG AN TOÀN");
			System.out.println("================================== HỆ THỐNG AN TOÀN ========================");
		} else {
			boolean checkresult= database.luuFileResult("HỆ THỐNG KHÔNG AN TOÀN");
			System.out.println("================================ HỆ THỐNG KHÔNG AN TOÀN =======================");
		}

	}

}
