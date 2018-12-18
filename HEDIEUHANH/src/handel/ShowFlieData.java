package handel;

import java.io.*;
import java.util.ArrayList;

import mode.DataBean;

public class ShowFlieData {
	public ArrayList<DataBean> showTable(String path){
		ArrayList<DataBean> arrayList = new ArrayList<DataBean>();
		try {
			FileInputStream fileInputStream = new FileInputStream(path);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String line = bufferedReader.readLine();
			String[] list = null;
			//DataBean bean = new DataBean();
			while(line!=null) {
				if(line.length()>0) {

					list = line.split("-");
					int l = list.length;
					//System.out.println("kich thuoc = "+ l);
					if(l==11){
						DataBean bean = new DataBean(list[0],list[1],list[2],list[3],list[4],list[5],list[6],list[7],list[8],list[9],list[10]);
						arrayList.add(bean);
					}
					else if(l==10) {
						DataBean bean = new DataBean(list[0],list[1],list[2],list[3],list[4],list[5],list[6],list[7],list[8],list[9]);
						arrayList.add(bean);
					}else if(l ==9) {
						DataBean bean = new DataBean(list[0],list[1],list[2],list[3],list[4],list[5],list[6],list[7],list[8]);
						arrayList.add(bean);
					}else if(l==8) {
						DataBean bean = new DataBean(list[0],list[1],list[2],list[3],list[4],list[5],list[6],list[7]);
						arrayList.add(bean);
					}else if(l==7) {
						DataBean bean = new DataBean(list[0],list[1],list[2],list[3],list[4],list[5],list[6]);
						arrayList.add(bean);
					}else if(l==6) {
						DataBean bean = new DataBean(list[0],list[1],list[2],list[3],list[4],list[5]);
						arrayList.add(bean);
					}else if(l==5) {
						DataBean bean = new DataBean(list[0],list[1],list[2],list[3],list[4]);
						arrayList.add(bean);
					}else if(l==4) {
						DataBean bean = new DataBean(list[0],list[1],list[2],list[3]);
						arrayList.add(bean);
					}else if(l==3) {
						DataBean bean = new DataBean(list[0],list[1],list[2]);
						arrayList.add(bean);
					}else if(l==2) {
						DataBean bean = new DataBean(list[0],list[1]);
						arrayList.add(bean);
					}else {
						DataBean bean = new DataBean(list[0]);
						arrayList.add(bean);
					}
				}
				line = bufferedReader.readLine();
			}
			bufferedReader.close();
			inputStreamReader.close();
			fileInputStream.close();
			return arrayList;
		} catch (Exception e) {
			return null;
		}
		
	}

	public boolean deleteFile(String source) throws IOException {
		File file = new File(source);
//          kiem tra nếu file tồn tại thì xóa
		if (file.exists()) {
			file.delete();
			return true;
		}
			return false;
	}
    //////////////////////////////////////////////////


	public String showResult(String path){
		try {
			FileInputStream fileInputStream = new FileInputStream(path);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String line ;
			line = bufferedReader.readLine();
			bufferedReader.close();
			inputStreamReader.close();
			fileInputStream.close();
			return line;
		} catch (Exception e) {
			return null;
		}

	}
}
