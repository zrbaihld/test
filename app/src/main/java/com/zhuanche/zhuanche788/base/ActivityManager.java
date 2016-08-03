package com.zhuanche.zhuanche788.base;

import java.util.LinkedList;
import java.util.ListIterator;

import android.app.Activity;

public class ActivityManager {
	private static ActivityManager appManager;
	private LinkedList<Activity> activities = new LinkedList<Activity>();

	private ActivityManager() {
	}

	public static ActivityManager getInstance() {
		if (appManager == null) {
			appManager = new ActivityManager();
		}
		return appManager;
	}

	public void clear() {
		if (activities == null) {
			activities = new LinkedList<Activity>();
		}
		activities.clear();
	}

	public void addAcitivity(Activity act) {
		if (activities == null) {
			activities = new LinkedList<Activity>();
		}
		activities.add(act);
	}

	public void removeAcitivity(Activity act) {
		if (activities == null) {
			activities = new LinkedList<Activity>();
		}
		activities.remove(act);
	}

	public void finishActivity(Activity activity) {
		if (activity == null) {
			return;
		}
		if (activities == null) {
			activities = new LinkedList<Activity>();
		}
		if (activities.contains(activity)) {
			if (!activity.isFinishing()) {
				activity.finish();
			}
		}
	}

	public void finishActivity(Class<?> cls) {
		for (Activity activity : activities) {
			if (activity.getClass().equals(cls)) {
				finishActivity(activity);
			}
		}
	}

	public void exit() {
		ListIterator<Activity> iteraor = activities.listIterator();
		while (iteraor.hasNext()) {
			Activity act = iteraor.next();
			iteraor.remove();
			if (act != null && !act.isFinishing()) {
				act.finish();
			}
		}
	}
}
