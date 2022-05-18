package com.zx.lintlib;

import com.android.tools.lint.client.api.IssueRegistry;
import com.android.tools.lint.detector.api.ApiKt;
import com.android.tools.lint.detector.api.Issue;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouxu
 * @descripe
 * @e-mail 374952705@qq.com
 * @time 2021/4/23
 */


public class IssueRegister extends IssueRegistry {
    @NotNull
    @Override
    public List<Issue> getIssues() {
        return new ArrayList<Issue>() {{
            add(LogDetector.ISSUE);
        }};
    }

    @Override
    public int getApi() {
        return ApiKt.CURRENT_API;
    }

    @Override
    public int getMinApi() {
        return 1;
    }
}
