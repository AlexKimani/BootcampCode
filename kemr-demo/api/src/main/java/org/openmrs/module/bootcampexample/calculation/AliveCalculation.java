package org.openmrs.module.bootcampexample.calculation;

import org.openmrs.calculation.BaseCalculation;
import org.openmrs.calculation.patient.PatientCalculation;
import org.openmrs.calculation.patient.PatientCalculationContext;
import org.openmrs.calculation.result.CalculationResultMap;
import org.openmrs.module.kenyacore.calculation.BooleanResult;
import org.openmrs.module.kenyacore.calculation.Filters;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by brayoni on 5/30/14.
 */
public class AliveCalculation extends BaseCalculation implements PatientCalculation {
    @Override
    public CalculationResultMap evaluate(Collection<Integer> cohort, Map<String, Object> parameterValues, PatientCalculationContext context) {
        Set<Integer> alive = Filters.alive(cohort, context);
        CalculationResultMap ret = new CalculationResultMap();

        for(Integer i: cohort ){
            if(alive.contains(i)){
                ret.put(i, new BooleanResult(true, this));
            }
        }
        return ret;
    }
}
