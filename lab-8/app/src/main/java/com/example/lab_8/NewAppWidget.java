package com.example.lab_8;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
        Intent intent1 = new Intent(Intent.ACTION_VIEW);
        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent1.setData(Uri.parse("https://dzen.ru/"));

        PendingIntent pIntent = PendingIntent.getActivity(context, 0, intent1, 0);
        remoteViews.setOnClickPendingIntent(R.id.btn_open_site, pIntent);

        appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }
}