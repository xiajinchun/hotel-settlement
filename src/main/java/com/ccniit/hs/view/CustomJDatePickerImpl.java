/**
Copyright 2004 Juan Heyns. All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are
permitted provided that the following conditions are met:

   1. Redistributions of source code must retain the above copyright notice, this list of
      conditions and the following disclaimer.

   2. Redistributions in binary form must reproduce the above copyright notice, this list
      of conditions and the following disclaimer in the documentation and/or other materials
      provided with the distribution.

THIS SOFTWARE IS PROVIDED BY JUAN HEYNS ``AS IS'' AND ANY EXPRESS OR IMPLIED
WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL JUAN HEYNS OR
CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

The views and conclusions contained in the software and documentation are those of the
authors and should not be interpreted as representing official policies, either expressed
or implied, of Juan Heyns.
 */
package com.ccniit.hs.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.SpringLayout;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import net.sourceforge.jdatepicker.DateModel;
import net.sourceforge.jdatepicker.JDatePanel;
import net.sourceforge.jdatepicker.JDatePicker;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import com.ccniit.hs.Constants;
import com.ccniit.hs.controller.CheckOutOperateController;
import com.ccniit.hs.controller.OperateController;
import com.ccniit.hs.controller.QueryOperateController;
import com.ccniit.hs.controller.SettlementOperateController;

/**
 * Created on 25 Mar 2004 Refactored 21 Jun 2004 Refactored 14 May 2009
 * Refactored 16 April 2010 Updated 26 April 2010
 * 
 * @author Juan Heyns
 * @author JC Oosthuizen
 * @author Yue Huang
 * @param <T>
 */
public class CustomJDatePickerImpl extends JPanel implements JDatePicker {

	private static final long serialVersionUID = 2814777654384974503L;

	private Popup popup;
	private JFormattedTextField formattedTextField;
	private JButton button;

	private JDatePanelImpl datePanel;
	private InternalEventHandler internalEventHandler;

	private OperateController operateController;

	public CustomJDatePickerImpl(OperateController operateController) {
		this(null, null);
		// Moodified by Charels Hsia
		this.operateController = operateController;
	}

	/**
	 * You are able to set the format of the date being displayed on the label.
	 * Formatting is described at:
	 * 
	 * http://java.sun.com/j2se/1.4.2/docs/api/java/text/SimpleDateFormat.html
	 * 
	 * @param datePanel
	 * @param formatter
	 */
	public CustomJDatePickerImpl(JDatePanelImpl datePanel, JFormattedTextField.AbstractFormatter formatter) {
		// Moodified by Charels Hsia
		UtilDateModel utilDateModel = new UtilDateModel();
		utilDateModel.setValue(Calendar.getInstance().getTime());
		this.datePanel = new JDatePanelImpl(utilDateModel);

		// Initialise Variables
		popup = null;
		this.datePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		internalEventHandler = new InternalEventHandler();

		// Create Layout
		SpringLayout layout = new SpringLayout();
		setLayout(layout);

		// Create and Add Components
		// Add and Configure TextField
		formattedTextField = new JFormattedTextField((formatter != null) ? formatter : createDefaultFormatter());
		this.setTextEditable(false);
		DateModel<?> model = this.datePanel.getModel();
		setTextFieldValue(formattedTextField, model.getYear(), model.getMonth(), model.getDay(), model.isSelected());
		formattedTextField.setEditable(false);
		add(formattedTextField);
		layout.putConstraint(SpringLayout.WEST, formattedTextField, 0, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, this, 0, SpringLayout.SOUTH, formattedTextField);

		// Add and Configure Button
		button = new JButton("...");
		button.setFocusable(true);
		add(button);
		layout.putConstraint(SpringLayout.WEST, button, 1, SpringLayout.EAST, formattedTextField);
		layout.putConstraint(SpringLayout.EAST, this, 0, SpringLayout.EAST, button);
		layout.putConstraint(SpringLayout.SOUTH, this, 0, SpringLayout.SOUTH, button);

		// Do layout formatting
		int h = (int) button.getPreferredSize().getHeight();
		int w = (int) this.datePanel.getPreferredSize().getWidth();
		button.setPreferredSize(new Dimension(h, h));
		formattedTextField.setPreferredSize(new Dimension(w - h - 1, h));

		// Add event listeners
		addHierarchyBoundsListener(internalEventHandler);
		// TODO addAncestorListener(listener)
		button.addActionListener(internalEventHandler);
		formattedTextField.addPropertyChangeListener("value", internalEventHandler);
		this.datePanel.addActionListener(internalEventHandler);
		this.datePanel.getModel().addChangeListener(internalEventHandler);
	}

	protected JFormattedTextField.AbstractFormatter createDefaultFormatter() {
		return new JFormattedTextField.AbstractFormatter() {
			private static final long serialVersionUID = 5997312768041129127L;

			@Override
			public String valueToString(Object value) throws ParseException {
				Calendar cal = (Calendar) value;
				if (cal == null) {
					return "";
				}
				return Constants.getDateFormatterInstance().format(cal.getTime());
			}

			@Override
			public Object stringToValue(String text) throws ParseException {
				return Constants.getDateFormatterInstance().parseObject(text);
			}
		};
	}

	public void addActionListener(ActionListener actionListener) {
		datePanel.addActionListener(actionListener);
	}

	public void removeActionListener(ActionListener actionListener) {
		datePanel.removeActionListener(actionListener);
	}

	public void setI18nStrings(Properties i18nStrings) {
		datePanel.setI18nStrings(i18nStrings);
	}

	public Properties getI18nStrings() {
		return datePanel.getI18nStrings();
	}

	public DateModel<?> getModel() {
		return datePanel.getModel();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sourceforge.jdatepicker.JDatePicker#setTextEditable(boolean)
	 */
	public void setTextEditable(boolean editable) {
		formattedTextField.setEditable(editable);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sourceforge.jdatepicker.JDatePicker#isTextEditable()
	 */
	public boolean isTextEditable() {
		return formattedTextField.isEditable();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sourceforge.jdatepicker.JDatePicker#setButtonFocusable(boolean)
	 */
	public void setButtonFocusable(boolean focusable) {
		button.setFocusable(focusable);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sourceforge.jdatepicker.JDatePicker#getButtonFocusable()
	 */
	public boolean getButtonFocusable() {
		return button.isFocusable();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sourceforge.jdatepicker.JDatePicker#getJDateInstantPanel()
	 */
	public JDatePanel getJDateInstantPanel() {
		return datePanel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sourceforge.jdatepicker.JDatePicker#getJFormattedTextField()
	 */
	public JFormattedTextField getJFormattedTextField() {
		return formattedTextField;
	}

	/**
	 * Called internally to popup the dates.
	 */
	private void showPopup() {
		if (popup == null) {
			PopupFactory fac = new PopupFactory();
			Point xy = getLocationOnScreen();
			datePanel.setVisible(true);
			popup = fac.getPopup(this, datePanel, (int) xy.getX(), (int) (xy.getY() + this.getHeight()));
			popup.show();
		}
	}

	/**
	 * Called internally to hide the popup dates.
	 */
	private void hidePopup() {
		if (popup != null) {
			popup.hide();
			popup = null;
		}
	}

	/**
	 * This internal class hides the public event methods from the outside
	 */
	private class InternalEventHandler implements ActionListener, HierarchyBoundsListener, ChangeListener, PropertyChangeListener {

		public void ancestorMoved(HierarchyEvent arg0) {
			hidePopup();
		}

		public void ancestorResized(HierarchyEvent arg0) {
			hidePopup();
		}

		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getSource() == button) {
				if (popup == null) {
					showPopup();
				} else {
					hidePopup();
				}
			} else if (arg0.getSource() == datePanel) {
				hidePopup();
			}
		}

		public void stateChanged(ChangeEvent arg0) {
			if (arg0.getSource() == datePanel.getModel()) {
				DateModel<?> model = datePanel.getModel();
				setTextFieldValue(formattedTextField, model.getYear(), model.getMonth(), model.getDay(), model.isSelected());
			}
		}

		public void propertyChange(PropertyChangeEvent evt) {
			if (formattedTextField.isEditable() && formattedTextField.getValue() != null) {
				Calendar value = (Calendar) formattedTextField.getValue();
				datePanel.getModel().setDate(value.get(Calendar.YEAR), value.get(Calendar.MONTH), value.get(Calendar.DATE));
				datePanel.getModel().setSelected(true);
			}
		}

	}

	public boolean isDoubleClickAction() {
		return datePanel.isDoubleClickAction();
	}

	public boolean isShowYearButtons() {
		return datePanel.isShowYearButtons();
	}

	public void setDoubleClickAction(boolean doubleClickAction) {
		datePanel.setDoubleClickAction(doubleClickAction);
	}

	public void setShowYearButtons(boolean showYearButtons) {
		datePanel.setShowYearButtons(showYearButtons);
	}

	private void setTextFieldValue(JFormattedTextField textField, int year, int month, int day, boolean isSelected) {
		if (!isSelected) {
			textField.setValue(null);
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.set(year, month, day, 0, 0, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			// Moodified by Charels Hsia
			textField.setValue(calendar);
			if (this.operateController instanceof CheckOutOperateController) {
				CheckOutOperateController cooc = (CheckOutOperateController) this.operateController;
				cooc.updateRoomNumberOptions(textField.getText());
			}
			if (this.operateController instanceof SettlementOperateController) {
				SettlementOperateController soc = (SettlementOperateController) this.operateController;
				soc.updateRoomTypeOption(textField.getText());
			}
			if (this.operateController instanceof QueryOperateController) {
				QueryOperateController qoc = (QueryOperateController) this.operateController;
				qoc.showRoomList(textField.getText());
			}
		}
	}
}
