// CSE2016 - Lab#03-2 ClockWriter

import java.awt.*;
import javax.swing.*;
import java.time.*;

public class ClockWriter extends JPanel {
	public ClockWriter() {
		int width = 200;
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
		int width = 200;
		// 바탕은 흰색으로
		g.setColor(Color.white);
		g.fillRect(0, 0, width, width);
		// 현재 시간 + 시침 분침 각도 계산
		LocalTime now = LocalTime.now();
		int minutes_angle = 90 - now.getMinute() * 6;
		int hours_angle = 90 - now.getHour() * 30;
		int seconds_angle = 90 - now.getSecond() * 6;
		// 시계판 그리기
		int x = 50;
		int y = 50;
		int diameter = 100;
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
	}
	
	public static void main(String[] args) {
		new ClockWriter();
	}
}