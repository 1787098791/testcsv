package com.freedom.test.testregex;

/**
 * @author ：wujie
 * @date ：Created in 2019/11/4 15:20
 * @description：密码强度规则验证
 * @version: 1.0.0
 */
public class Testpasswordregex {

    public static void main(String[] args) {
        Integer core = regex("s1aabbb");
        System.out.println(core);

    }

    public static Integer regex(String password){

        //密码长度验证
        int length = password.length();
        int passwordLengthCore=0;
        if (length>=6&&length<=7){
            passwordLengthCore=10;
        }else if(length>=8){
            passwordLengthCore=25;
        }else {
            throw new RuntimeException("密码长度不符合规则");
        }

        //密码大小写字母的验证
        int passwordLetterCore=0;
        String upperRegex=".*[A-Z]+.*";
        String lowerRegex=".*[a-z]+.*";
        String blendRegex=".*[a-zA-Z]+.*";
        //1代表大写或小写 2代表混合
        int letterTag=0;
        if ((password.matches(upperRegex)&&(!password.matches(lowerRegex)))||(password.matches(lowerRegex)&&(!password.matches(upperRegex)))){
            passwordLetterCore=10;
            letterTag=1;
        }else if(password.matches(blendRegex)){
            letterTag=2;
            passwordLetterCore=25;
        }else{
            throw new RuntimeException("密码必须包含字母");
        }

        //密码数字的验证
        int passwordNumCore=0;
        String zeroRegex=".*[0-9]{0}.*";
        String oneRegex=".*[0-9]{1,2}.*";
        String threeRegex=".*[0-9]{3,}.*";
        //0代表无数字 1代表有数字
        int numTag=0;
        if (password.matches(threeRegex)){
            passwordNumCore=20;
            numTag=1;
        }else if (password.matches(oneRegex)){
            passwordNumCore=10;
            numTag=1;
        }

       //符号的验证
        int passwordSymbolCore=0;
        String regex="[a-zA-Z0-9]+";
        String str = password.replaceAll(regex, "");
        //0代表无符号 1代表有符号
        int symbolTag=0;
        if (str.length()>1){
            passwordSymbolCore=20;
            symbolTag=1;
        }else if (str.length()==1){
            passwordSymbolCore=10;
            symbolTag=1;
        }

        //奖励积分
        int rewardCore=0;
        if (letterTag==2&&numTag==1&&symbolTag==1){
            rewardCore=10;
        }else if (letterTag==1&&numTag==1&&symbolTag==1){
            rewardCore=5;
        }else if(letterTag==1&&numTag==1){
            rewardCore=2;
        }

        return passwordLengthCore+passwordLetterCore+passwordNumCore+passwordSymbolCore+rewardCore;
    }


}
