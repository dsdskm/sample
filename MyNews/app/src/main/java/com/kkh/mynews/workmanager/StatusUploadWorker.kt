package com.kkh.mynews.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.kkh.mynews.common.Constant

class StatusUploadWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {

    companion object {
        const val TAG = Constant.TAG_PREFIX + "StatusUploadWorker"
    }

    override fun doWork(): Result {
        Log.d(TAG,"doWork")
        return Result.success()
    }
}