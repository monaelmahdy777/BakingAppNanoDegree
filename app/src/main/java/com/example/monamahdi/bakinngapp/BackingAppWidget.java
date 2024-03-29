package com.example.monamahdi.bakinngapp;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.RemoteViews;

/**
 * Implementation of App Widget functionality.
 */
public class BackingAppWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {
        SharedPreferences preferences = context.getSharedPreferences("pref", 0);

        CharSequence defaultName = context.getString(R.string.appwidget_text);

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.backing_app_widget);
        views.setTextViewText(R.id.appwidget_title, preferences.getString("widget_title", defaultName.toString()));
        views.setTextViewText(R.id.appwidget_body, preferences.getString("widget_body", ""));

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

