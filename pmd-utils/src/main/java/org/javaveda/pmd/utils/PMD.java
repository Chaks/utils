/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaveda.pmd.utils;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Chakravarthi
 */
@XmlRootElement(name = "pmd")
public class PMD {

  private List<SourceFile> sourceFiles;

  @XmlElement(name = "file")
  public List<SourceFile> getSourceFiles() {
    return sourceFiles;
  }

  public void setSourceFiles(List<SourceFile> sourceFiles) {
    this.sourceFiles = sourceFiles;
  }

  @Override
  public String toString() {
    return "PMD{" + "sourceFiles=" + sourceFiles + '}';
  }
}
