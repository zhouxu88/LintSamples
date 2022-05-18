package com.zx.lintlib

import com.android.tools.lint.detector.api.*
import com.intellij.psi.PsiMethod
import org.jetbrains.uast.UCallExpression

/**
 * @descripe
 *
 * @author zhouxu
 * @e-mail 374952705@qq.com
 * @time   2021/4/23
 */


open class LogDetector2 : Detector(), Detector.UastScanner {

    companion object{
        val issue: Issue by lazy {
            Issue.create(
                    "LogUsage",
                    "避免调用android.util.Log",
                    "请勿直接调用android.util.Log，应该使用统一的Log工具类",
                    Implementation(LogDetector2::class.java,Scope.JAVA_FILE_SCOPE),
                    "",
                    Category.SECURITY,
                    5,
                    Severity.WARNING,
                    true
            )
        }
    }



    override fun getApplicableMethodNames(): List<String>? {
        return arrayListOf("v", "d", "i", "w", "e")
    }

    override fun visitMethod(context: JavaContext, node: UCallExpression, method: PsiMethod) {
        if (context.evaluator.isMemberInClass(method, "android.util.Log")) {
            context.report(issue, node, context.getLocation(node), "请勿直接调用android.util.Log，应该使用统一Log工具类");
        }
    }


}