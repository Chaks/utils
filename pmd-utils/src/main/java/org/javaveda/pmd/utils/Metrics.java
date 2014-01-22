/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaveda.pmd.utils;

import com.google.common.base.Functions;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Chakravarthi
 */
public class Metrics {

  private static Map<String, Integer> priorityMap = new HashMap<String, Integer>();
  private static Map<String, Integer> ruleMap = new HashMap<String, Integer>();
  private static Map<String, Integer> rulesetMap = new HashMap<String, Integer>();

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) throws Exception {
    JAXBContext context = JAXBContext.newInstance(PMD.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();
    PMD pmd = (PMD) unmarshaller.unmarshal(new FileReader(args[0]));
    System.out.println(pmd);
    for (SourceFile sourceFile : pmd.getSourceFiles()) {
      System.out.println("" + sourceFile.getName());
      for (Violation violation : sourceFile.getViolations()) {
        handleCount(priorityMap, violation.getPriority());
        handleCount(ruleMap, violation.getRule());
        handleCount(rulesetMap, violation.getRuleset());
      }
    }
    //System.out.println("priorityMap=> " + priorityMap);
    //System.out.println("ruleMap=> " + ruleMap);
    //System.out.println("rulesetMap=> " + rulesetMap);
    Map<String, Integer> sortedPriorityMap = Maps.newTreeMap(Ordering.natural().reverse().onResultOf(Functions.forMap(priorityMap)).compound(Ordering.natural()));
    sortedPriorityMap.putAll(priorityMap);
    System.out.println("sortedPriorityMap=> " + sortedPriorityMap);
    Map<String, Integer> sortedRuleMap = Maps.newTreeMap(Ordering.natural().reverse().onResultOf(Functions.forMap(ruleMap)).compound(Ordering.natural()));
    sortedRuleMap.putAll(ruleMap);
    System.out.println("sortedRuleMap=> " + sortedRuleMap);
    Map<String, Integer> sortedRulesetMap = Maps.newTreeMap(Ordering.natural().reverse().onResultOf(Functions.forMap(rulesetMap)).compound(Ordering.natural()));
    sortedRulesetMap.putAll(rulesetMap);
    System.out.println("sortedRulesetMap=> " + sortedRulesetMap);
  }

  private static void handleCount(Map<String, Integer> map, String key) {
    if (map.containsKey(key)) {
      map.put(key, Integer.valueOf(map.get(key)) + 1);
    } else {
      map.put(key, Integer.valueOf(1));
    }
  }
}
