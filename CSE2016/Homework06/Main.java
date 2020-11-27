public class Main {
  public static void main(String[] args) {

    // boolean 배열로 초기 값을 입력해줍니다.
    // boolean을 선택한 이유: boolean은 데이터 크기가 작기 때문에 int보다 효율적이라 생각했습니다.

    // 일반화까지 완료되었기 때문에 정사각 배열이라는 점만 맞추어서 데이터를 입력해주면
    // 크기에 상관없이 자동으로 계산하여 실행됩니다.

    // 주석 처리 해제 후 테스트하실 수 있습니다.

    //// 1. 깜빡이
    // boolean[][] arr = {
    //   {false, false, false, false, false},
    //   {false, false, false, false, false},
    //   {false, true, true, true, false},
    //   {false, false, false, false, false},
    //   {false, false, false, false, false},
    // };

    //// 2. 두꺼비
    // boolean[][] arr = {
    //   {false, false, false, false, false, false},
    //   {false, false, false, false, false, false},
    //   {false, false, true, true, true, false},
    //   {false, true, true, true, false, false},
    //   {false, false, false, false, false, false},
    //   {false, false, false, false, false, false},
    // };

    //// 3. 등대
    // boolean[][] arr = {
    //   {false, false, false, false, false, false},
    //   {false, true, true, false, false, false},
    //   {false, true, false, false, false, false},
    //   {false, false, false, false, true, false},
    //   {false, false, false, true, true, false},
    //   {false, false, false, false, false, false},
    // };

    //// 4. 펄서
    boolean[][] arr = {
      {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
      {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
      {false, false, false, false, true, true, false, false, false, false, false, true, true, false, false, false, false},
      {false, false, false, false, false, true, true, false, false, false, true, true, false, false, false, false, false},
      {false, false, true, false, false, true, false, true, false, true, false, true, false, false, true, false, false},
      {false, false, true, true, true, false, true, true, false, true, true, false, true, true, true, false, false},
      {false, false, false, true, false, true, false, true, false, true, false, true, false, true, false, false, false},
      {false, false, false, false, true, true, true, false, false, false, true, true, true, false, false, false, false},
      {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
      {false, false, false, false, true, true, true, false, false, false, true, true, true, false, false, false, false},
      {false, false, false, true, false, true, false, true, false, true, false, true, false, true, false, false, false},
      {false, false, true, true, true, false, true, true, false, true, true, false, true, true, true, false, false},
      {false, false, true, false, false, true, false, true, false, true, false, true, false, false, true, false, false},
      {false, false, false, false, false, true, true, false, false, false, true, true, false, false, false, false, false},
      {false, false, false, false, true, true, false, false, false, false, false, true, true, false, false, false, false},
      {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
      {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
    };

    // length of arr = 바둑판 가로세로크기
    int len = arr.length;
    GameWriter gw = new GameWriter(len);
    GameController gc = new GameController(gw, arr);
    gc.updateGeneration();
  }
}