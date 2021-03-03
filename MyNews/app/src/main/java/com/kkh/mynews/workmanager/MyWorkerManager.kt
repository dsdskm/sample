package com.kkh.mynews.workmanager

import androidx.work.*
import com.kkh.mynews.MyNewsApplication
import java.util.concurrent.TimeUnit

class MyWorkerManager {
    companion object {
        fun workRequest() {
            val uploadWorkRequest: WorkRequest =
                OneTimeWorkRequestBuilder<StatusUploadWorker>().build()
            WorkManager.getInstance(MyNewsApplication.getAppContext()).enqueue(uploadWorkRequest)
        }

        fun workRequestOneTime() {
            val request = OneTimeWorkRequest.from(LogUploadWorker::class.java)
            WorkManager.getInstance(MyNewsApplication.getAppContext()).enqueue(request)
        }

        fun workRequestMutiTime(){
            val request = PeriodicWorkRequestBuilder<LogUploadWorker>(10, TimeUnit.SECONDS)
                .build()
            WorkManager.getInstance(MyNewsApplication.getAppContext()).enqueue(request)
        }
        fun workRequestWithChargingWithNetwork(){
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.UNMETERED)
                .setRequiresCharging(true)
                .build()

            val myWorkRequest: WorkRequest =
                OneTimeWorkRequestBuilder<LogUploadWorker>()
                    .setConstraints(constraints)
                    .build()
            WorkManager.getInstance(MyNewsApplication.getAppContext()).enqueue(myWorkRequest)

        }
    }
}