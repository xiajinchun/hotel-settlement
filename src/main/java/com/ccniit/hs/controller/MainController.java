package com.ccniit.hs.controller;

import com.ccniit.hs.view.MainFrame;

public class MainController {
	private static MainController instance = new MainController();
	private MainFrame mainFrame = new MainFrame(this);

	public static MainController getInstance() {
		return instance;
	}

	public void setOperateController(OperateController operateController) {
		operateController.initPanelData();
		this.mainFrame.setOperatePanel(operateController.getOperatePanel());
	}

	public void exit() {
		this.mainFrame.showExitDialog();
	}

}