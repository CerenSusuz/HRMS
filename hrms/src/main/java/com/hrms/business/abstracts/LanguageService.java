package com.hrms.business.abstracts;

import java.util.List;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Language;

public interface LanguageService {
	Result add(Language language);
	DataResult<List<Language>> getAll();
	DataResult<List<Language>> getByJobSeekerId(int jobSeekerId);
}
