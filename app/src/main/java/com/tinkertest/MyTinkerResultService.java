package com.tinkertest;

import com.tencent.tinker.lib.service.DefaultTinkerResultService;
import com.tencent.tinker.lib.service.PatchResult;
import com.tencent.tinker.lib.util.TinkerLog;

/**
 * 补丁加载成功服务回调
 * 切记在manifest文件注册此service，否则会报找不到service
 * Created by 黄海 on 2017/4/1.
 */
public class MyTinkerResultService extends DefaultTinkerResultService {
    private static final String TAG = "Tinker.MyTinkerResultService";

    @Override
    public void onPatchResult(PatchResult result) {
        if (result != null) {
            TinkerLog.i(TAG, "补丁加载成功 patchInfo=" + result);
            /**
             * 补丁加载成功，note！此处不代表应用成功
             *此处做的事情发送请求告诉服务器补丁加载成功（if need）
             */
        }
        super.onPatchResult(result);
    }
}
