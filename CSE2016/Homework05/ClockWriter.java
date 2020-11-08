import java.awt.*;
import javax.swing.*;
import java.time.*;

public class ClockWriter extends JPanel {
	
	private int width = 200;
	// private int minute;

	public ClockWriter() {
		// 프레임 생성 ㅇ
		JFrame clock_frame = new JFrame();
		// 자신(패널)을 프레임에 끼우기 
		clock_frame.getContentPane().add(this);
		// 프레임 만들어 보여주기 
		clock_frame.setTitle("Clock");
		clock_frame.setSize(width,width);
		clock_frame.setVisible(true);
		clock_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public void paintComponent(Graphics g) {
		// 바탕은 흰색으로 
		g.setColor(Color.white);
		g.fillRect(0, 0, width, width);
		// 현재 시간 + 시침, 분침, 초 각도 계산
		LocalTime now = LocalTime.now();
		int seconds_angle = 90 - now.getSecond() * 6; 
		int minutes_angle = 90 - now.getMinute() * 6;
		// minute = now.getMinute();
		int hours_angle = 90 - now.getHour() * 30 - (now.getMinute()/12)*6;
		// 시계 판 그리기
		int x = 50;
		int y = 50;
		int diameter = 100;
		g.setColor(Color.black);
		g.drawOval(x, y, diameter, diameter);
		// 눈금 그리기
        int i = 0;
        g.fillArc(x, y, diameter, diameter, -1 + 30*i++, 2);
        g.fillArc(x, y, diameter, diameter, -1 + 30*i++, 2);
        g.fillArc(x, y, diameter, diameter, -1 + 30*i++, 2);
        g.fillArc(x, y, diameter, diameter, -1 + 30*i++, 2);
        g.fillArc(x, y, diameter, diameter, -1 + 30*i++, 2);
        g.fillArc(x, y, diameter, diameter, -1 + 30*i++, 2);
        g.fillArc(x, y, diameter, diameter, -1 + 30*i++, 2);
        g.fillArc(x, y, diameter, diameter, -1 + 30*i++, 2);
        g.fillArc(x, y, diameter, diameter, -1 + 30*i++, 2);
        g.fillArc(x, y, diameter, diameter, -1 + 30*i++, 2);
        g.fillArc(x, y, diameter, diameter, -1 + 30*i++, 2);
        g.fillArc(x, y, diameter, diameter, -1 + 30*i++, 2);
        g.setColor(Color.WHITE);
		g.fillOval(x+5, y+5, diameter-10, diameter-10);
		// 디지털 시계 그리기
		g.setColor(Color.black);
		g.drawString(((now.getHour()+11)%12+1) + "시 " + now.getMinute() + "분 " + now.getSecond() + "초", 10, 20);
		LocalDate today = LocalDate.now();
		g.drawString(today.getYear() + "년 " + today.getMonthValue() + "월 " + today.getDayOfMonth() + "일", 10, 40);
		// 초침 그리기
		g.fillArc(x+10, x+10, diameter-20, diameter-20, seconds_angle, -3);
		// 분침 그리기
		g.setColor(Color.red);
		g.fillArc(x+5, x+5, diameter-10, diameter-10, minutes_angle, 5);
		// 시침 그리기 
		g.setColor(Color.blue);
		g.fillArc(x+25, x+25, diameter-50, diameter-50, hours_angle, -8);
	}

	public void updateTime() {
		this.repaint();
	}
}
