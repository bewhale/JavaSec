package org.bewhale.javasec.controller.basevul;

import com.sun.deploy.net.HttpUtils;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.EvaluationException;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParseException;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home/spel")
public class SPELVul {

    @RequestMapping("")
    public String spelVul(String exp, Model model) {
        try {
            // 1. 创建解析器：SpEL使用ExpressionParser接口表示解析器，提供SpelExpressionParser默认实现
            ExpressionParser parser = new SpelExpressionParser();
            // StandardEvaluationContext权限过大，可以执行任意代码
            EvaluationContext evaluationContext = new StandardEvaluationContext();

            // 2. 解析表达式: 使用ExpressionParser的parseExpression来解析相应的表达式为Expression对象
            // 3. 求值：通过 Expression 接口的 getValue 方法根据上下文获得表达式值
            String result = parser.parseExpression(exp).getValue(evaluationContext).toString();
            model.addAttribute("results", result);
        } catch (ParseException e) {
            e.printStackTrace();
            model.addAttribute("results", e.toString());
        }
        return "/basevul/spel/spel";
    }
}
