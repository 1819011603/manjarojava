package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class L_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

      HashMap<String,Integer> l = new HashMap<>(),r;
      for (String s: wordList){
          l.put(s,-1);
      }
      if(!l.containsKey(endWord))return 0;
      r = new HashMap<>(l);
      r.put(beginWord,-1);
      Deque<String> rr = new LinkedList<>();
      Deque<String> ll = new LinkedList<>();
      ll.add(beginWord);
      rr.add(endWord);
      int lm = 0;
      while (ll.size() > 0 && r.size() > 0){


          int size = ll.size();
          for(int i = 0; i < size; i++){
              String cur = ll.pollFirst();
              Integer integer = r.get(cur);
              if (integer != -1){
                  return lm+ integer+1;
              }
              l.put(cur,lm);
              int length = cur.length();
              char[] chars = cur.toCharArray();
              for (int j = 0; j < length; j++){
                  char o = chars[j];
                  for (char c=  'a' ; c<='z'; c++){
                      chars[j] = c;
                      String e = new String(chars);
                      Integer integer1 = l.get(e);
                      if (integer1!= null && integer1 == -1){
                          ll.addLast(e);

                      }
                  }
                  chars[j] = o;
              }
          }
          size = rr.size();
          for(int i = 0; i < size; i++){
              String cur = rr.pollFirst();
              Integer integer = l.get(cur);
              if (integer != -1){
                  return lm+ integer+1;
              }
              r.put(cur,lm);
              int length = cur.length();
              char[] chars = cur.toCharArray();
              for (int j = 0; j < length; j++){
                  char o = chars[j];
                  for (char c=  'a' ; c<='z'; c++){
                      chars[j] = c;
                      String e = new String(chars);
                      Integer integer1 = r.get(e);
                      if (integer1!= null && integer1 == -1){
                          rr.addLast(e);

                      }
                  }
                  chars[j] = o;
              }
          }

          lm++;
      }


        return 0;

    }

    public static void main(String[] args) {
        String[] strings = new String[]{"hot","dot","dog","lot","log","cog"};
        List<String> list = Arrays.stream(strings).collect(Collectors.toList());
        System.out.println(new L_127().ladderLength("hit","cog",list));
    }


}
