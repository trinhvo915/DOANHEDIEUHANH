package banker;

public class BankerMainConsole {

	public static void main(String[] args) {
		
		ActionBanker actionBanker = new ActionBanker();
		actionBanker.CreateData();
		actionBanker.PrintData();
		actionBanker.RunProcessor();
	}

}
