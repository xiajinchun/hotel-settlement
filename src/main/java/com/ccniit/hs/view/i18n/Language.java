package com.ccniit.hs.view.i18n;

import java.util.HashMap;
import java.util.Locale;

public abstract class Language {
	private static HashMap<Locale, Language> availableLocales = new HashMap<Locale, Language>();
	private static Locale currentLocale = Locale.ENGLISH;
	private static Language instance;

	static {
		Language.availableLocales.put(Locale.ENGLISH, new English());
		English.setCurrentLocale(Locale.ENGLISH);
		Language.availableLocales.put(Locale.SIMPLIFIED_CHINESE, new SimplifiedChinese());
	}

	public static Locale getCurrentLocale() {
		return currentLocale;
	}

	public static Language getInstance() {
		if (instance == null) {
			instance = availableLocales.get(currentLocale);
		}
		return instance;
	}

	public static void setCurrentLocale(final Locale newLocale) {
		if (!Language.currentLocale.equals(newLocale)) {
			Language.currentLocale = newLocale;
			Language.instance = availableLocales.get(newLocale);
		}
	}

	public abstract String roomNumber();

	public abstract String roomType();

	public abstract String customerName();

	public abstract String price();

	public abstract String checkInDate();

	public abstract String pledge();

	public abstract String inputCustomerName();

	public abstract String inputPrice();

	public abstract String inputPledge();

	public abstract String inputRoomNumber();

	public abstract String inputCheckInDate();

	public abstract String confirmCheckIn();

	public abstract String confirmCancel();

	public abstract String checkInSucceed();

	public abstract String checkInFail();

	public abstract String query();

	public abstract String checkin();

	public abstract String settlement();

	public abstract String checkout();

	public abstract String exit();

	public abstract String queryRoomInfo();

	public abstract String confirmExit();

	public abstract String checkinRoomInfo();

	public abstract String querySettlementInfo();

	public abstract String customerCheckOut();

	public abstract String dateChoose();

	public abstract String checkoutTime();

	public abstract String returnPledge();

	public abstract String checkoutRoomInfo();

	public abstract String noRoomInfoOrCheckout();

	public abstract String checkOutSucceed();

	public abstract String checkOutFail();

	public abstract String submitQuery();

	public abstract String rooms();

	public abstract String typeIncome();

	public abstract String todayIncome();

	public abstract String totalPledge();

	public abstract String unReturnPledge();

	public abstract String submit();

	public abstract String error();

	public abstract String succeed();

	public abstract String fail();

	public abstract String prompt();

	public abstract String cancel();
}