package fr.sii.sonar.web.client.scss.duplication;

import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.component.ResourcePerspectives;
import org.sonar.api.config.Settings;
import org.sonar.api.rules.RuleFinder;

import fr.sii.sonar.duplication.cpd.provider.CpdProvider;
import fr.sii.sonar.duplication.simian.provider.SimianProvider;
import fr.sii.sonar.report.core.common.ReportSensor;
import fr.sii.sonar.report.core.common.factory.FallbackProviderFactory;
import fr.sii.sonar.report.core.duplication.domain.DuplicationReport;
import fr.sii.sonar.report.core.duplication.factory.DuplicationSaverFactory;

/**
 * Sensor specific to code duplication that loads duplication report (either CPD or Simian)
 * 
 * @author Aurélien Baudet
 *
 */
public class ScssDuplicationSensor extends ReportSensor<DuplicationReport> {

	@SuppressWarnings("unchecked")
	public ScssDuplicationSensor(ScssDuplicationConstants constants, Settings settings, RuleFinder ruleFinder, FileSystem filesystem, ResourcePerspectives resourcePerspective) {
		super(constants, settings, ruleFinder, filesystem, resourcePerspective, new FallbackProviderFactory<DuplicationReport>(CpdProvider.class, SimianProvider.class), new DuplicationSaverFactory());
	}

}
