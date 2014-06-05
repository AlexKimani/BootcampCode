package org.openmrs.module.bootcampexample.calculation;

import org.openmrs.Concept;
import org.openmrs.calculation.BaseCalculation;
import org.openmrs.calculation.Calculation;
import org.openmrs.calculation.patient.PatientCalculation;
import org.openmrs.calculation.patient.PatientCalculationContext;
import org.openmrs.calculation.result.CalculationResultMap;
import org.openmrs.calculation.result.SimpleResult;
import org.openmrs.module.kenyacore.calculation.Calculations;
import org.openmrs.module.kenyaemr.Dictionary;
import org.openmrs.module.kenyaemr.calculation.EmrCalculationUtils;

import java.util.Collection;
import java.util.Map;

/**
 * Created by brayoni on 5/30/14.
 */
public class EntryPointCalculation extends BaseCalculation implements PatientCalculation{
    @Override
    public CalculationResultMap evaluate(Collection<Integer> cohort, Map<String, Object> stringObjectMap, PatientCalculationContext context) {
        CalculationResultMap crm = Calculations.lastObs(Dictionary.getConcept(Dictionary.METHOD_OF_ENROLLMENT), cohort, context);
        CalculationResultMap ret = new CalculationResultMap();

        for(Integer pId:cohort){
            Concept entryPoint = EmrCalculationUtils.codedObsResultForPatient(crm,pId);
            if(crm.containsKey(pId)){
                ret.put(pId, new SimpleResult(entryPoint, this, context));
            }
        }
        return ret;
    }
}
