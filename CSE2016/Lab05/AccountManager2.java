/* 시동 클래스 
 * 입력 포맷 
 *   P     - 주계좌
 *   S     - 보조계
 *   D 금액 - 입금 
 *   W 금액 - 출금 
 *   Q     - 종료 
 * 출력 
 *   거래 결과 */

// CSE2016 - Lab#5 

public class AccountManager2 {

	public static void main(String[] args) {
		BankReader reader = new BankReader();
		BankAccount primary_account = new BankAccount(0);
		BankAccount secondary_account = new BankAccount(0);
		BankWriter primary_writer = new BankWriter("자유은행 계좌#1", primary_account);
		BankWriter secondary_writer = new BankWriter("자유은행 계좌#2", secondary_account);
		AccountController2 controller = new AccountController2(reader, primary_writer, primary_account, 
						                                               secondary_writer, secondary_account);
		controller.processTransactions();
	}
}

