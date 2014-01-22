/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaveda.pmd.utils;

import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Chakravarthi
 */
@XmlRootElement(name = "file")
public class SourceFile {

  private String name;
  private List<Violation> violations;

  @XmlAttribute(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @XmlElement(name = "violation")
  public List<Violation> getViolations() {
    return violations;
  }

  public void setViolations(List<Violation> violations) {
    this.violations = violations;
  }

  @Override
  public String toString() {
    return "SourceFile{" + "name=" + name + ", violations=" + violations + '}';
  }
}
