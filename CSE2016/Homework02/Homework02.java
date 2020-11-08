import java.awt.*;
import javax.swing.*;
import java.time.*;

public class Homework02 extends JPanel {
	public Homework02() {
		int width = 300;
		// 프레임 생성
		JFrame clock_frame = new JFrame();
		// 패널을 프레임에 끼우기
		clock_frame.getContentPane().add(this);
		// 프레임을 만들어 보여주기
		clock_frame.setTitle("Clock");
		clock_frame.setSize(width, width);
		clock_frame.setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
		int width = 300;
		// 바탕은 흰색으로
		g.setColor(Color.white);
		g.fillRect(0, 0, width, width);
		// 현재 시간 + 시침 분침 각도 계산
		LocalTime now = LocalTime.now();
    LocalDate date = LocalDate.now();
    // String date = currentDate.format(DateTimeFormatter.BASIC_ISO_DATE);
    

		int minutes_angle = 90 - now.getMinute() * 6;
		int hours_angle = 90 - now.getHour() * 30;
		int seconds_angle = 90 - now.getSecond() * 6;
		// 시계판 그리기
		int x = 75;
		int y = 75;
		int diameter = 150;

    g.setColor(Color.black);
    g.fillArc(x, x, diameter, diameter, 30, 2);
    g.fillArc(x, x, diameter, diameter, 60, 2);
    g.fillArc(x, x, diameter, diameter, 90, 2);
    g.fillArc(x, x, diameter, diameter, 120, 2);
    g.fillArc(x, x, diameter, diameter, 150, 2);
    g.fillArc(x, x, diameter, diameter, 180, 2);
    g.fillArc(x, x, diameter, diameter, 210, 2);
    g.fillArc(x, x, diameter, diameter, 240, 2);
    g.fillArc(x, x, diameter, diameter, 270, 2);
    g.fillArc(x, x, diameter, diameter, 300, 2);
    g.fillArc(x, x, diameter, diameter, 330, 2);
    g.fillArc(x, x, diameter, diameter, 360, 2);
    g.setColor(Color.white);
    g.fillOval(x+5, y+5, diameter-10, diameter-10);

    // for문을 사용하지 못하므로 주석처리 하였습니다.
    // for(int i=1; i<=60; i++) {
		//   g.setColor(Color.black);
    //   if(i%5 == 0) {
    //     g.fillArc(x, x, diameter, diameter, i*6, 2);
    //   }
    //   else {
    //     g.fillArc(x, x, diameter, diameter, i*6, 1);
    //   }
		//   g.setColor(Color.white);
		//   g.fillOval(x+5, y+5, diameter-10, diameter-10);
    // }
    
		g.setColor(Color.black);
		g.drawOval(x, y, diameter, diameter);
		// 분침 그리기
		g.setColor(Color.red);
		g.fillArc(x+5, x+5, diameter-10, diameter-10, minutes_angle, 5);
		// 시침 그리기
		g.setColor(Color.blue);
		g.fillArc(x+25, x+25, diameter-50, diameter-50, hours_angle, -8);
		// 초침 그리기
		g.setColor(Color.black);
		g.fillArc(x+10, x+10, diameter-20, diameter-20, seconds_angle, 3);
		// 10의 의미: 시작하는 사각형의 좌표를 조금 더 원의 중심에 가깝게 해서 원이 작아짐
		// diameter : 사각형 안의 원의 지름
    g.drawString(date.getYear() + "년 " + date.getMonthValue() + "월 " + date.getDayOfMonth() + "일", 100, 35);
    g.drawString(now.getHour() + "시 " + now.getMinute() + "분 " + now.getSecond() + "초 ", 100, 50);
	}
	
	public static void main(String[] args) {
		new Homework02();
	}
}