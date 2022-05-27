package edu.goncharova.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "statistics", schema = "quiz")
public class Statistics extends Base {}
