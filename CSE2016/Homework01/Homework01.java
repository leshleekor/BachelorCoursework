public class Homework01 {
  public static void main(String[] args) {
    int money = 1000000*Integer.parseInt(args[0]);
    int year = Integer.parseInt(args[1]);
    double r = Double.parseDouble(args[2]);
    double a = Math.pow(1+(r/1200), year*12);
    double d = (a * money * (r/1200)) / (a - 1);
    System.out.printf("자유은행 대출 상환금 계산 서비스에 오심을 환영합니다 .\n\n");
    System.out.println("손님의 대출원금은 " + args[0] + "백만원 입니다.");
    System.out.printf("연이자율 %.1f%%로 %d 년 동안\n", r, year);
    System.out.printf("매월 원리금 균등으로 %d 원씩 상환하셔야 합니다 .\n", (int)d);
    System.out.printf("총 상환금액은 %d 원 입니다.\n\n", (int)d*year*12);
    System.out.println("저희 자유은행은 항상 여러분과 함께 합니다 .");
    System.out.println("또 들려주세요.");
  }
}