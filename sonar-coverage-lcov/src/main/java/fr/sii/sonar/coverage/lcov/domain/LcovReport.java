package fr.sii.sonar.coverage.lcov.domain;

import java.util.ArrayList;
import java.util.List;

import fr.sii.sonar.coverage.lcov.parser.LcovEndStatement;
import fr.sii.sonar.coverage.lcov.parser.LcovTestNameStatement;
import fr.sii.sonar.report.core.domain.report.Report;

/**
 * Provides an abstraction of the LCOV format. It contains all information about
 * code coverage for each covered file :
 * <ul>
 * <li>the covered functions (numbers and details)</li>
 * <li>the covered lines (numbers and details)</li>
 * <li>the covered code branches (numbers and details)</li>
 * </ul>
 * 
 * @author Aurélien Baudet
 *
 * @see LcovTestNameStatement
 * @see LcovEndStatement
 */
public class LcovReport implements Report {

	/**
	 * The name of the test (optional)
	 */
	private String testName;

	/**
	 * The list of covered files with details
	 */
	private List<FileCoverage> files;

	public LcovReport() {
		this(null, new ArrayList<FileCoverage>());
	}

	public LcovReport(String testName, List<FileCoverage> files) {
		super();
		this.testName = testName;
		this.files = files;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public List<FileCoverage> getFiles() {
		return files;
	}

	public void setFiles(List<FileCoverage> files) {
		this.files = files;
	}

	public void addFileInfo(FileCoverage file) {
		files.add(file);
	}
}
