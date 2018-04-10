package org.latko.random.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.latko.random.model.RandomModel;
import org.latko.random.service.RandomService;
import org.latko.random.service.RandomServiceException;

@RestController
@RequestMapping(value = "/random")
public class RandomController {
    @Autowired
    RandomService randomService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody RandomModel create(@RequestBody final RandomModel randomModel) throws RandomServiceException {
        return randomService.create(randomModel);
    }

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    public @ResponseBody String random(@RequestParam final Map<String, String> requestParameters) throws RandomServiceException {
        return "suck";
    }
}
