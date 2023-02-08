package com.example.mystore.data.repository

import android.content.Context
import com.example.mystore.data.models.Notification
import com.example.mystore.data.notification_provider.NotificationFromSharedPreference

class NotificationRepository (context: Context){
    private val notificationProvider = NotificationFromSharedPreference(context)

    fun getAllNotifications(): MutableList<Notification>{
        return notificationProvider.getAllNotifications()
    }

    fun deleteNotification(notification: Notification){
        notificationProvider.deleteNotification(notification)
    }
    fun saveNotification(notification: Notification) {
        notificationProvider.saveNotification(notification)
    }
}