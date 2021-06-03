package com.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.LinkService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.ErrorDataResult;
import com.hrms.core.utilities.results.ErrorResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.LinkDao;
import com.hrms.entities.concretes.Link;

@Service
public class LinkManager implements LinkService {
	
	private LinkDao linkDao;

	@Autowired
	public LinkManager(LinkDao linkDao) {
		super();
		this.linkDao = linkDao;
	}
	
	@Override
	public Result add(Link link) {
		var result = this.linkDao.save(link);
		if (result != null) {
			return new SuccessResult("link add ok");
		}
		return new ErrorResult("link add NOT ok");
	}

	@Override
	public DataResult<List<Link>> getAll() {
		var result = this.linkDao.findAll();
		if (result != null) {
			return new SuccessDataResult<List<Link>>(result,"links get ok");
		}
		return new ErrorDataResult<List<Link>>("links get NOT ok");
	}

	@Override
	public DataResult<List<Link>> getByJobSeekerId(int jobSeekerId) {
		var result = this.linkDao.getByJobSeekerId(jobSeekerId);
		if (result != null) {
			return new SuccessDataResult<List<Link>>(result,"links get by jobSeeker Id ok");
		}
		return new ErrorDataResult<List<Link>>("links get by jobSeeker Id NOT ok");
	}

}
