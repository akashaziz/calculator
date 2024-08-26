package com.example.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/")
    public String showCalculator() {
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam("number1") double number1,
                            @RequestParam("number2") double number2,
                            @RequestParam("operation") String operation,
                            Model model) {
        double result = 0;

        switch (operation) {
            case "add":
                result = number1 + number2;
                break;
            case "subtract":
                result = number1 - number2;
                break;
            case "multiply":
                result = number1 * number2;
                break;
            case "divide":
                if (number2 != 0) {
                    result = number1 / number2;
                } else {
                    model.addAttribute("error", "Cannot divide by zero");
                }
                break;
        }

        model.addAttribute("result", result);
        return "calculator";
    }
}
