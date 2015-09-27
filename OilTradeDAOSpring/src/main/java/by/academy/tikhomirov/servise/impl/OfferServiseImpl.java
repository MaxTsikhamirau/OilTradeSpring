package by.academy.tikhomirov.servise.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.academy.tikhomirov.pojos.Offer;
import by.academy.tikhomirov.pojos.Sort;
import by.academy.tikhomirov.pojos.User;
import by.academy.tikhomirov.repository.OfferRepository;
import by.academy.tikhomirov.repository.SortRepository;
import by.academy.tikhomirov.repository.UserRepository;
import by.academy.tikhomirov.servise.interf.OfferServise;
import by.academy.tikhomirov.vo.OfferVO;
import by.academy.tikhomirov.vo.SortVO;
import by.academy.tikhomirov.vo.UserVO;

@Service
public class OfferServiseImpl implements OfferServise {
	private static final Logger logger = Logger.getLogger(OfferServiseImpl.class.getName());

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OfferRepository offerRepository;
	@Autowired
	private SortRepository sortRepository;

	@Override
	public List<OfferVO> getAppropriateOffers(String sort_name, int quantity, int price) {
		logger.info("Getting list of appropriate offers where sort_name:= " + sort_name + " ,quantity>= " + quantity
				+ " ,price<= " + price + " : start");
		List<Offer> offers = new ArrayList<>();
		offers = offerRepository.getAppropriateOffers(sort_name, quantity, price);
		List<OfferVO> offersVO = extract(offers);
		if (offersVO.size() < 1) {
			logger.info("There're no appropriate offers");
		}
		logger.info("Getting list of appropriate offers: complete");
		return offersVO;
	}

	@Override
	public List<OfferVO> getAll() {
		logger.info("Getting list of offers: start");
		List<Offer> offers = new ArrayList<>();
		offers = offerRepository.findAll();
		List<OfferVO> offersVO = extract(offers);
		logger.info("Getting list of offers: complete");
		return offersVO;

	}

	private List<OfferVO> extract(List<Offer> offers) {
		List<OfferVO> offersVO = new ArrayList<>();
		for (Offer offer : offers) {
			OfferVO offerVO = new OfferVO();
			offerVO.setOffer_id(offer.getOffer_id());
			offerVO.setPrice(offer.getPrice());
			offerVO.setQuantity(offer.getQuantity());
			offerVO.setUserVO(extract(offer.getUser()));
			offerVO.setSortVO(extract(offer.getSort()));
			offersVO.add(offerVO);
		}
		return offersVO;
	}

	private SortVO extract(Sort sort) {
		SortVO sortVO = new SortVO();
		sortVO.setSort_id(sort.getSort_id());
		sortVO.setSort_name(sort.getSort_name());
		return sortVO;
	}

	private UserVO extract(User user) {
		logger.debug("Extracting user to userVO: start");
		UserVO userVO = new UserVO();
		userVO.setUser_id(user.getUser_id());
		userVO.setUser_name(user.getUser_name());
		userVO.setLogin(user.getLogin());
		userVO.setPassword(user.getPassword());
		userVO.setCity(user.getUserDetail().getCity());
		userVO.setCountry(user.getUserDetail().getCountry());
		userVO.setTelephone(user.getUserDetail().getTelephone());
		logger.debug("Extracting user to userVO: complete");
		return userVO;
	}

	@Override
	public List<OfferVO> getOffersByUserId(int user_id) {
		logger.info("Getting list of offers by user_id= " + user_id + " : start");
		List<Offer> offers = new ArrayList<>();
		offers = offerRepository.getOffersByUserId(user_id);
		List<OfferVO> offersVO = extract(offers);
		logger.info("Getting list of offers by user_id= " + user_id + ": complete");
		return offersVO;
	}

	@Override
	public void edit(OfferVO offerVO) {

		logger.info("Editing offer: start");
		Offer offer = offerRepository.findOne(offerVO.getOffer_id());
		Sort sort = sortRepository.findOne(offerVO.getSortVO().getSort_id());
		sort.setSort_name(offerVO.getSortVO().getSort_name());
		offer.setSort(sort);
		offer.setPrice(offerVO.getPrice());
		offer.setQuantity(offerVO.getQuantity());
		offerRepository.saveAndFlush(offer);
		logger.info("Editing offer: complete");
	}

	@Override
	public void add(OfferVO offerVO) {
		logger.info("Start creating offer: " + offerVO);
		Offer offer = transform(offerVO);
		offerRepository.save(offer);
		logger.info("Offer: " + offer + " was created");
	}

	private Offer transform(OfferVO offerVO) {
		logger.debug("Transformation offerVO to offer: start");
		Sort sort = sortRepository.getSortByName(offerVO.getSortVO().getSort_name());
		User user = userRepository.findOne(offerVO.getUserVO().getUser_id());
		Offer offer = new Offer();
		offer.setPrice(offerVO.getPrice());
		offer.setQuantity(offerVO.getQuantity());
		offer.setSort(sort);
		offer.setUser(user);
		logger.debug("Transformation offerVO to offer: complete");
		return offer;
	}

}
