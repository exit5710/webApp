package controller;

import json.JsonAction;

import racers.action.RacerListAction;
import racers.action.RacerViewAction;
import racers.action.RacerSaveAction;

public class UserActionFactory {
	private static UserActionFactory singleton;

	public static UserActionFactory getInstance() {
		if (singleton == null) {
			singleton = new UserActionFactory();
		}

		return singleton;
	}

	public Action action(String command) {
		String views = "./WEB-INF/views";
		Action action = null;

		switch (command) {
			case "/racerView":
				action = new RacerViewAction(views + "/racers/racerView.jsp");
				break;

			case "/racerSave":
				action = new RacerSaveAction();
				break;

			case "/racerList":
				action = new RacerListAction();
				break;

			case "/json":
				action = new JsonAction();
				break;
		}

		return action;
	}
}