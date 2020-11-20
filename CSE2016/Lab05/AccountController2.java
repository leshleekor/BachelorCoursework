// CSE2016 - Lab#5 

public class AccountController2 {
	
	private BankReader reader; // input-view
	private BankWriter primary_writer; // output-view
	private BankWriter secondary_writer;
	private BankAccount primary_account; // model
	private BankAccount secondary_account;
	private BankAccount account; // remembers active account
	private BankWriter writer; // remembers active writer
	private BankAccount inactive_account;
	private BankWriter inactive_writer;
	
	/* AccountController 객체 초기 
	 * @param r - input-view 객체 
	 * @param w - output-view 객체
	 * @param a - model 객체 */
	public AccountController2(BankReader r, BankWriter w1, BankAccount a1,
			                                BankWriter w2, BankAccount a2) {
		reader = r;
		primary_writer = w1;
		secondary_writer = w2;
		primary_account = a1;
		secondary_account = a2;
		// 기본은 주계좌
		account = primary_account;
		writer = primary_writer;
		// 비활성 계좌, 기본은 second 계좌
		inactive_account = secondary_account;
		inactive_writer = secondary_writer;
	}
	
	/* resetAccount - 계좌 변경 
	 * @param new_account - 변경할 계좌 
	 * @param new_writer - 변경할 출력기 */
	private void resetAccount(BankAccount new_account, BankWriter new_writer) {
		inactive_account = account;
		inactive_writer = writer;
		writer.showTransaction("비활성");
		account = new_account;
		writer = new_writer;
		writer.showTransaction("활성");
	}
	
	/* processTransactions - Q 요청을 할 때까지 고객의 요청을 처리 */
	public void processTransactions() {
		char command = reader.readCommand("계좌#1 P, 계좌#2 S, 샌드 >금액, 리시브 <금액, 입금 D금액, 출금 W금액, 종료 Q);");
		if (command == 'Q') {
			writer.showTransaction("서비스를 마칩니다.");
			return;
		}
		else if (command == 'D') {
			int amount = reader.readAmount();
			if (account.deposit(amount))
				writer.showTransaction(amount, "입금");
			else
				writer.showTransaction("입금 실패");
		}
		else if (command == 'W') {
			int amount = reader.readAmount();
			if (account.withdraw(amount))
				writer.showTransaction(amount, "출금");
			else
				writer.showTransaction("출금 실패");
		}
		else if (command == 'P') 
			resetAccount(primary_account, primary_writer);
		else if (command == 'S')
			resetAccount(secondary_account, secondary_writer);
		else if (command == '>') {
			int amount = reader.readAmount();
			send(amount);
		} 
		else if (command == '<') {
			int amount = reader.readAmount();
			receive(amount);
		}
		else
			writer.showTransaction("요청 오류");
		this.processTransactions();
	}

	private void send(int amount) {
		if (account.withdraw(amount)) {
			writer.showTransaction(amount, "원 출금");
			inactive_account.deposit(amount);
			inactive_writer.showTransaction(amount, "원 입금");
		}
	}

	private void receive(int amount) {
		if (inactive_account.withdraw(amount)) {
			inactive_writer.showTransaction(amount, "원 출금");
			writer.showTransaction(amount, "원 입금");
			account.deposit(amount);
		}
	}
}

