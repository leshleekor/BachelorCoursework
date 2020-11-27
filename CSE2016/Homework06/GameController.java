import javax.swing.*;

public class GameController {

  private GameWriter writer;
  private int boardSize;
  private boolean[][] arr = null;
  private boolean[][] newArr = null;

  /* GameController
   * 정사각형 배열의 한 변의 길이(요소의 개수)를 인자로 받음 
   */
  public GameController(GameWriter gw, boolean[][] br) {
    writer = gw;
    boardSize = br.length;
    arr = br;
    newArr = new boolean[boardSize][boardSize];
    for(int i=0; i<boardSize; i++) {
      for(int j=0; j<boardSize; j++) {
        newArr[i][j] = false;
      }
    }
    writer.updateScreen(arr);
  }

  /* check
   * 검사 함수, 해당 칸의 세포 생사를 true, false로 반환, 
   * 배열 범위를 이탈한 경우 false 반환
   * 인자로 검사할 좌표의 위치를 받음.
   */
  private boolean check(int x, int y) {
    if(x < 0 || y < 0 || x >= boardSize || y >= boardSize) {
      return false;
    } else {
      if(arr[x][y] == true) {
        return true;
      } else {
        return false;
      }
    }
  }

  /* countRound
   * 주변 8칸에 대해서 check 함수를 실행하여 주변 8칸 내에 세포가 몇개 있는지 조사 
   * 조사할 중심 좌표를 인자로 받음. (중심좌표를 기준으로 주변 8칸 조사하므로)
   */
  private int countRound(int x, int y) {
    int count = 0;
    for(int i=y-1; i<=y+1; i++) {
      for(int j=x-1; j<=x+1; j++) {
        if(y==i && x==j) continue;
        if(check(j, i)) count++;
      }
    }
    return count;
  }

  /* checkAll
   * 배열 전체에게 countRound를 실행시키고, countRound에서 반환되는 count 값을 중심 좌표에 저장
   * count 값은 주변에 몇개의 세포가 살아있는지 나타내는 값이므로, 이를 이용해 연산한다.
   */
  private int[][] countAll() {
    int[][] temp = new int[boardSize][boardSize];
    for(int i=0; i<boardSize; i++) {
      for(int j=0; j<boardSize; j++) {
        temp[i][j] = countRound(i,j);
      }
    }
    return temp;
  }

  /* updateArray
   * countAll에서 주변 세포의 개수를 받아와서,
   * 규칙에 맞게 판단해서 다음 세대의 생사 여부를 boolean 값으로 체크한다.
   * 그리고 새 어레이를 기존 어레이 배열에 저장한다.
   * 
   * 죽어있는 세포는 이웃 세포가 정확히 3개가 살아있으면 살아난다.
   * 살아있는 세포는 이웃세포 중 2개 또는 3개가 살아있으면 생명을 유지, 너무 적으면 외로워서, 너무 많으면 숨막혀서 죽음.
   */
  private void updateArray() {
    int[][] countArr = countAll();
    for(int i=0; i<boardSize; i++) {
      for(int j=0; j<boardSize; j++) {
        newArr[i][j] = isAliveNextGen(i, j, countArr[i][j]);
      }
    }
    arr = newArr;
  }

  /* isAliveNextGen
   * 규칙 판단 함수
   */
  private boolean isAliveNextGen(int x, int y, int c) {
    if(arr[x][y] == false && c == 3) {
      return true;
    }
    else if(arr[x][y] == true && (c == 2 || c == 3)) {
      return true;
    } else {
      return false;
    }
  }
  
  /* updateGeneration
   * 1초마다 반복되게끔 설정.
   */
  public void updateGeneration() {
    int time_unit = 1;
    int painting_delay = 1000;
    int i=0;
    while(i<=9) {
      // testPrint();
      delay(painting_delay);
      updateArray();
      writer.updateScreen(arr);
      i++;
    }
    JOptionPane.showMessageDialog(null, "Animation Finished,\n2018042797 Seunghyeon Lee");
  }

  /* testPrint
   * 콘솔창에 어레이를 1과 0으로 출력
  */
  public void testPrint() {
    for(int i=0; i<boardSize; i++) {
      for(int j=0; j<boardSize; j++) {
        System.out.print(arr[i][j] ? 1 : 0);
      }
      System.out.println();
    }
  }

  private void delay(int how_long) {
    try { Thread.sleep(how_long); }
    catch(InterruptedException e) {}
  }
}