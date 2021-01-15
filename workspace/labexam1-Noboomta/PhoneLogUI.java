import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.BevelBorder;

/**
 * Visual display of phone call log.
 * This uses the Java Swing graphics framework.
 * 
 * @author jim
 */
public class PhoneLogUI extends JFrame implements Runnable {
	// an empty call record to fill up the list
	private final CallRecord EMPTYCALL = new CallRecord("   ");
	private final int FONTSIZE = 18;
	private JTextField inputField;
	private PhoneLog phoneLog;
	private PhoneListModel model;
	
	/** Run as main class. */
	public static void main(String[] args) {
		final int capacity = 5;
		String title = String.format("Phone Log with capacity %d", capacity);
		PhoneLog phoneLog = new PhoneLog(capacity);
		PhoneLogUI ui = new PhoneLogUI(phoneLog, title);
		SwingUtilities.invokeLater(ui);
	}
	
	public PhoneLogUI(PhoneLog log, String title) {
		this.phoneLog = log;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(title);
	}
	
	/** initialize components and display the window. */
	public void run() {
		initComponents();
		setVisible(true);
	}

	/** initialize GUI components and event handlers. */
	private void initComponents() {
		inputField = new JTextField(12);
		inputField.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD, FONTSIZE));
		model = new PhoneListModel();
		JList<CallRecord> phoneList = new JList<>(model);
		phoneList.setFont(new Font(Font.MONOSPACED, Font.PLAIN, FONTSIZE));
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Phone number to record:");
		label.setFont(new Font(Font.DIALOG, Font.PLAIN, FONTSIZE));
		panel.add(label);
		panel.add(inputField);
		panel.setBorder( BorderFactory.createBevelBorder(BevelBorder.RAISED));
		this.add( panel, BorderLayout.NORTH);
		phoneList.setBorder(BorderFactory.createTitledBorder("Phone Log (most recent calls first)"));
		this.add( phoneList, BorderLayout.CENTER);
		inputField.addActionListener( new InputAction() );
		this.pack();
		
	}
	
	/** Update the display when new phone numbers are recorded. */
	private void update() {
		model.setPhoneNumbers( phoneLog.getCalls() );
	}
	
	/** A JList model that gets data from PhoneLog */
	@SuppressWarnings("serial")
	class PhoneListModel extends AbstractListModel<CallRecord> {
		private CallRecord[] elements = new CallRecord[] {};
		private final int MIN_SIZE = 10;
		
		public PhoneListModel() {
			super();
		}
		
		public void setPhoneNumbers(CallRecord[] phoneNumbers) {
			// if arrays are same then do nothing
			//if (java.util.Arrays.equals(elements, phoneNumbers)) return;
			int first = 0;
			int last = phoneNumbers.length -1;
			this.elements = phoneNumbers;
			super.fireContentsChanged(this, first, last);
		}

		public int getSize() {
			// always return some size > 0 to keep list from collapsing
			return Math.max(MIN_SIZE, elements.length);
		}

		public CallRecord getElementAt(int index) {
			if (index >= 0 && index < elements.length) return elements[index];
			return EMPTYCALL;
		}
	}

	/** An action to handle phone number input. */
	class InputAction extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e) {
			String input = inputField.getText().trim();
			if (input.isEmpty()) return;
			phoneLog.recordCall(input);
			// phoneLog isn't observable, so force UI to update
			inputField.setText("");
			update();
		}
	}
	
}
