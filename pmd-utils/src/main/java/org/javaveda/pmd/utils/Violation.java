/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaveda.pmd.utils;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Chakravarthi
 */
@XmlRootElement(name = "violation")
public class Violation {

  private String className;
  private String rule;
  private String ruleset;
  private String priority;
  private String description;

  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlAttribute(name = "class")
  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlAttribute(name = "rule")
  public String getRule() {
    return rule;
  }

  public void setRule(String rule) {
    this.rule = rule;
  }

  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlAttribute(name = "ruleset")
  public String getRuleset() {
    return ruleset;
  }

  public void setRuleset(String ruleset) {
    this.ruleset = ruleset;
  }

  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlAttribute(name = "priority")
  public String getPriority() {
    return priority;
  }

  public void setPriority(String priority) {
    this.priority = priority;
  }

  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlValue
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "Violation{" + "className=" + className + ", rule=" + rule + ", "
            + "ruleset=" + ruleset + ", priority=" + priority + ", description=" + description + '}';
  }
}
