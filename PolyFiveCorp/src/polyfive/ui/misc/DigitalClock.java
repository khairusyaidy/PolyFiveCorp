package polyfive.ui.misc;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class DigitalClock extends JFrame implements ActionListener {
	JLabel timeLabel = new JLabel();
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	Timer timer;

	public DigitalClock() {

	}

	public DigitalClock(JLabel label) {
		// Run the constuctor for the parent JFrame class.

		// Exit the program when the user closes the window.

		// Get the current system time and display it
		// according to the format we defined.
		timeLabel.setText(sdf.format(new Date(System.currentTimeMillis())));

		// Set a larger, nicer font for the digital clock than the default.
		timeLabel.setFont(new Font("Dialog", Font.PLAIN, 24));

		// Set the timer to update the clock every 500 milliseconds (0.5
		// seconds)
		timer = new Timer(500, this);
		timer.setRepeats(true);
		timer.start();

		// Add the time display to the window and make it visible.
		label.add(timeLabel);
		label.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		// If the timer caused this event.
		if (e.getSource().equals(timer)) {
			// Then set a new time.
			timeLabel.setText(sdf.format(new Date(System.currentTimeMillis())));
		}

	}

}
