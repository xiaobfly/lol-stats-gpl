package log.ds.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

import log.ds.Champion;
import log.ds.GameType;
import log.ds.Map;
import log.ds.SummonerStats;
import log.ds.QueueType;

public class Game implements Serializable {
	
	private static final long serialVersionUID = -6540623759565099655L;
	
	/** Valor estático para ir asignando un identificador a cada juego creado */
	private static long nextId = 0;

	/** Identificador del juego */
	private long id;
	
	/** Dificultad del juego */
	private String difficulty;
	
	/** Duración del juego */
	private int gameLength;
	
	/** Lista de campeones baneados */
	private ArrayList<Champion> bannedChampions;
	
	/** Fecha y hora de creación de la partida */
	private GregorianCalendar creationTime;
	
	/** Tipo de juego */
	private GameType gameType;
	
	/** Tipo de cola */
	private QueueType queueType;
	
	/** Nombre del juego */
	private String name;
	
	/** ¿Tenía password la partida? */
	private boolean hasPassword;
	
	/** Mapa donde se ha jugado */
	private Map map;
	
	/** Jugadores del equipo 1 */
	HashMap<String, SummonerStats> team1;
	
	/** Jugadores del equipo 2 */
	HashMap<String, SummonerStats> team2;

	public Game() {
		id = nextId++;
		difficulty = null;
		gameLength = -1;
		bannedChampions = null;
		creationTime = null;
		gameType = null;
		queueType = null;
		name = null;
		hasPassword = false;
		map = null;
		team1 = null;
		team2 = null;
	}
	
	@Override
	public String toString() {
		return "Game [id=" + id + ", difficulty=" + difficulty
				+ ", gameLength=" + gameLength + ", bannedChampions="
				+ bannedChampions + ", creationTime=" + creationTime
				+ ", gameType=" + gameType + ", queueType=" + queueType
				+ ", name=" + name + ", hasPassword=" + hasPassword + ", map="
				+ map + ", team1=" + team1 + ", team2=" + team2 + "]";
	}
	
	/* Accesoras y modificadoras */
	public static void setNextId(long newNextId) {nextId = newNextId;}
	
	public long getId() {return id;}

	public String getDifficulty() {return difficulty;}
	public void setDifficulty(String difficulty) {this.difficulty = difficulty;}

	public int getGameLength() {return gameLength;}
	public void setGameLength(int gameLength) {this.gameLength = gameLength;}

	public ArrayList<Champion> getBannedChampions() {return bannedChampions;}
	public void setBannedChampions(ArrayList<Champion> bannedChampions) {this.bannedChampions = bannedChampions;}

	public GregorianCalendar getCreationTime() {return creationTime;}
	public void setCreationTime(GregorianCalendar creationTime) {this.creationTime = creationTime;}

	public GameType getGameType() {return gameType;}
	public void setGameType(GameType gameType) {this.gameType = gameType;}

	public QueueType getQueueType() {return queueType;}
	public void setQueueType(QueueType queueType) {this.queueType = queueType;}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public boolean isHasPassword() {return hasPassword;}
	public void setHasPassword(boolean hasPassword) {this.hasPassword = hasPassword;}

	public Map getMap() {return map;}
	public void setMap(Map map) {this.map = map;}

	public HashMap<String, SummonerStats> getTeam1() {return team1;}
	public void setTeam1(HashMap<String, SummonerStats> team1) {this.team1 = team1;}

	public HashMap<String, SummonerStats> getTeam2() {return team2;}
	public void setTeam2(HashMap<String, SummonerStats> team2) {this.team2 = team2;}
	
	public HashMap<String, SummonerStats> getSummoners() {
		if (team1 == null || team2 == null)
			return new HashMap<String, SummonerStats>();
		
		HashMap<String, SummonerStats> summoners = new HashMap<String, SummonerStats>(team1);
		for (SummonerStats s : team2.values())
			summoners.put(s.getSummonerName(), s);
		return summoners;
	}
	
}
