package impl;

import java.util.Map;
import adt.Stack;


public class MapTester {

        public static void aMethod() throws Exception {
            try {
                System.out.print("one ");
                throw new Exception();
         //       System.out.print("two ");
            } catch (Exception e) {
                System.out.print("three ");
            }
            System.out.print("four ");
        }
        public static void main(String args[]) {
            try {
                System.out.print("five ");
                aMethod();
                System.out.print("six ");
            } catch (Exception e) {
                System.out.print("seven ");
            }
            System.out.print("eight ");
        }
    }

