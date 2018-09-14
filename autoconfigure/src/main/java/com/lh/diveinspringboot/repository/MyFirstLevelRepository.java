package com.lh.diveinspringboot.repository;

import com.lh.diveinspringboot.annotation.FirstLevelRepository;
import com.lh.diveinspringboot.annotation.SecondLevelRepository;

@SecondLevelRepository(value = "myFirstLevelRepository")
public class MyFirstLevelRepository {
}
