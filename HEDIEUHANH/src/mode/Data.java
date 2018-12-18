package mode;

public class Data{
	private static int Max [][] = new int [10][10];
	private static int Allocation [][]= new int [10][10];
	private static int Need [][] = new int [10][10];
	private static int Available [] = new int [10];
	private static int q ; // so tien trinh
	private static int p ; // so tai nguyen

	public static int[][] getMax() {
		return Max;
	}
	public static void setMax(int[][] max) {
		for(int i = 0; i < q ; i++) {
			for(int j = 0; j < p ; j++) {
				Max[i] [j] = max[i][j];
			}
		}

	}

	public static int[][] getAllocation() {
		return Allocation;
	}
	public static void setAllocation(int[][] allocation) {
		for(int i = 0; i < q ; i++) {
			for(int j = 0; j < p ; j++) {
				Allocation[i] [j] = allocation[i][j];
			}
		}
	}
	public static int[][] getNeed() {
		return Need;
	}
	public static void setNeed(int[][] need) {
		for(int i = 0; i < q ; i++) {
			for(int j = 0; j < p ; j++) {
				Need[i] [j] = need[i][j];
			}
		}

	}
	public static int[] getAvailable() {
		return Available;
	}
	public static void setAvailable(int[] available) {
		for(int i = 0 ; i < p ; i++) {
			Available[i] = available[i];
		}
	}
	public static int getQ() {
		return q;
	}
	public static void setQ(int q) {
		Data.q = q;
	}
	public static int getP() {
		return p;
	}
	public static void setP(int p) {
		Data.p = p;
	}

	public void printTableMax() {
		System.out.println("--- BẢNG DỮ LIỆU MAX ----");
		System.out.print("       ");
		for (int j = 0; j < p; j++) {
			System.out.print("P[" + (j+1) + "]    ");
		}
		System.out.println();
		for (int i = 0; i < q; i++) {
			System.out.print("Q[" + (i+1) + "]");
			for (int j = 0; j < p; j++) {

				System.out.print("     " + Max[i][j] +"  ");
			}
			System.out.println();
		}
	}

	public void printTableAllo() {
		System.out.println("--- BẢNG DỮ LIỆU ALLOCATION ----");
		System.out.print("       ");
		for (int j = 0; j < p; j++) {
			System.out.print("P[" + (j+1) + "]    ");
		}
		System.out.println();
		for (int i = 0; i < q; i++) {
			System.out.print("Q[" + (i+1) + "]");
			for (int j = 0; j < p; j++) {

				System.out.print("     " + Allocation[i][j] +"  ");
			}
			System.out.println();
		}
	}

	public void printTableAvai() {
		System.out.println("--- BẢNG DỮ LIỆU AVAILABLE ----");
		System.out.print("       ");
		for (int j = 0; j < p; j++) {
			System.out.print("P[" + (j+1) + "]    ");
		}
		System.out.println();
		System.out.print("       ");
		for (int j = 0; j < p; j++) {
			System.out.print("  " + Available[j] +"     ");
		}
		System.out.println();
	}

	public void printTableNeed() {
		System.out.println("--- BẢNG DỮ LIỆU NEED ----");
		System.out.print("       ");
		for (int j = 0; j < p; j++) {
			System.out.print("P[" + (j+1) + "]    ");
		}
		System.out.println();
		for (int i = 0; i < q; i++) {
			System.out.print("Q[" + (i+1) + "]");
			for (int j = 0; j < p; j++) {

				System.out.print("     " + Need[i][j] +"  ");
			}
			System.out.println();
		}
		System.out.println("============================== CHECK =============================");
	}

}
