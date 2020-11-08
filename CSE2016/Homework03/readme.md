# Homework#03

꽃밭에서 꽃의 모양 및 위치는 위의 사례를 참고로 자유로이 디자인할 수 있으나, 다음 조건을 반드시 만족해야 한다.

꽃의 모양은 모두 같아야 하고, 크기는 모두 달라야 한다.
꽃잎은 5개 이상 있어야 한다.
꽃 및 배경 색깔은 자유로이 선택할 수 있지만, 같은 꽃의 꽃잎 색깔은 모두 같아야 한다.
꽃밭에는 꽃이 4송이 이상 있어야 한다.
그리고 다음 두 개의 메소드는 반드시 포함하고 있어야 한다.

꽃 그리는 메소드
```
public void drawFlower(Graphics g, int x, int y, int r, Color c1, Color c2)
```

꽃잎 그리는 메소드
```
private void drawPetal(Graphics g, int x, int y, int r, int angle, Color color)
```