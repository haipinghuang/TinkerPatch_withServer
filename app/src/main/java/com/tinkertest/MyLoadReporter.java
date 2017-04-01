package com.tinkertest;

import android.content.Context;

import com.tencent.tinker.lib.reporter.DefaultLoadReporter;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.loader.shareutil.ShareConstants;

import java.io.File;

/**
 * Created by 黄海 on 2017/4/1.
 */

public class MyLoadReporter extends DefaultLoadReporter {
    private static final String TAG = "Tinker.MyLoadReporter";
    private Context context;

    public MyLoadReporter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public void onLoadResult(File patchDirectory, int loadCode, long cost) {
        if (loadCode == ShareConstants.ERROR_LOAD_OK) {
            /**
             * 补丁应用成功,此处可以请求告知服务器(if need)
             * currentVersion就是下载下来的patch file 的文件MD5
             */
            String currentVersion = Tinker.with(context).getTinkerLoadResultIfPresent().currentVersion;
            TinkerLog.i(TAG, "当前补丁信息:md5=" + currentVersion);
        }
        super.onLoadResult(patchDirectory, loadCode, cost);
    }
}
