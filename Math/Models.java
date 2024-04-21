package calculations;

import java.util.Vector;
import java.util.HashSet;
import java.util.HashMap;
import java.lang.Math;

class BeautifulPlacesResult;

public class BeautifulPlaceTerm extends Term {
    public BeautifulPlaceTerm(Coordinates coords, double radius, BeautifulPlacesResult places) {
        this.coords = coords;
        this.places = places;
        this.radius = radius;
    }

    @Override
    public double calculate() {
        double result = 0;
        for(int i = 0; i < places.data.size(); i++) {
            result += Utils.distFunction(places.data[i].place.location.distance);
        }

        result /= maxNumberOfPlaces;
        return result;
    }

    const int maxNumberOfPlaces = 5;
    BeautifulPlaceResult places;
}

class ClinicResult;

public class ClinicTerm extends Term {
    public ClinicTerm(Coordinates coords, double radius, ClinicResult clinics) {
        this.coords = coords;
        this.clinics = clinics;
        this.radius = radius;

        // Рассчитываю дистанции до больниц и поликлиник в районе
        distances = new Vector<double>();
        for(int i = 0; i < clinics.count; i++)
        {
            if(getDistrict(coords) == clinics.resutls[i].district)
            {
                Coordinates clinicCoords = new Coordinates(clinics.results[i].coordinates[0], clinics.results[i].coordinates[1]);
                distances.add(Utils.distance(coords, clinicCoords));
            }
        }
    }

    @Override
    public double calculate() {
        if(distances.isEmpty()) return 0;
        return Utils.distFunction(Collections.min(distances));
    }

    ClinicResult clinics;
    Vector<double> distances;
}

class KindergartensResult;

public class KindergartensTerm extends Term {
    public KindergartensTerm(Coordinates coords, double radius, KindergartensResult kindergartens) {
        this.coords = coords;
        this.kindergartens = kindergartens;
        this.radius = radius;
    }

    @Override
    public double calculate() {
        double result = 0;
        for(KindergartensResult.Data kindergarten: kindergartens.data) {
            double distance = Utils.distance(coords, kindergarten.coords);
            if(distance <= radius)
                result += Utils.distFunction(calculatePlaces(kindergarten.sum));
        }
        return result;
    }

    private double calculatePlaces(int sum)
    {
        if (sum > 15) return 1;
        return Utils.logWithOffset(sum, 2, 1.23);
    }

    KindergartensResult kindergartens;
}

class KudaGOResult;

public class KudaGOTerm extends Term {
    public KudaGOTerm(Coordinates coords, double radius, KudaGOResult kudaGoResult) {
        this.coords = coords;
        this.kudaGoResult = kudaGoResult;
        this.radius = radius;
    }

    @Override
    public double calculate() {
        double result = 0;
        for(int i = 0; i < maxNumberOfEvents; i++) {
            Coordinates eventCoordinates = new Coordinates(kudaGoResult.data[i].place.coords[0], kudaGoResult.data[i].place.coords[1]);
            result += Utils.distFunction(Utils.distance(coords, coordinates));
        }
        result /= maxNumberOfEvents;
    }

    int numberOfEvents;
    const int maxNumberOfEvents = 15;
    KudaGOResult kudaGoResult;
}

class LibrariesResult;

public class LibrariesTerm extends Term {
    public LibrariesTerm(Coordinates coords, double radius, LibrariesResult libraries) {
        this.coords = coords;
        this.libraries = libraries;
        this.radius = radius;
    }

    @Override
    public double calculate() {
        return libraries.AllCount / maxNumberOfEvents;
    }

    const int maxNumberOfEvents = 15;
    LibrariesResult libraries;
}

class MinCultResult;

public class MinCultTerm extends Term {
    public MinCultTerm(Coordinates coords, double radius, MinCultResult minCult) {
        this.coords = coords;
        this.minCult = minCult;
        this.radius = radius;

        distances = new Vector<double>();
        for(int i = 0; i < minCult.count; i++) {
            double distance = Utils.distance(coords, new Coordinates(minCult.data[i].address_coordinates[0], minCult.data[i].address_coordinates[1])); 
            if(distance <= radius)
                distances.add(distance);
        }
    }

    @Override
    public double calculate() {
       if(distances.isEmpty()) return 0;
       return Utils.distFunction(Collections.min(distances)); 
    }

    MinCultResult minCult;
    Vector<double> distances;
}

class MuseumResult;

public class MuseumsTerm extends Term {
    public MuseumsTerm(Coordinates coords, double radius, MuseumResult museums) {
        this.coords = coords;
        this.museums = museums;
        this.radius = radius;

        distances = new Vector<double>();
        for(int i = 0; i < museums.count; i++) {
            double distance = Utils.distance(coords, new Coordinates(museums.data[i].coord[0], museums.data[i].coord[1]));
            if(distance <= radius)
                distances.add(distance);
        }
    }

    @Override
    public double calculate() {
        double result = 0;
        for(int i = 0; i < distances.size() && i < maxNumberOfMuseums; i++) {
            result += Utils.distFunction(distances[i]);
        }
        result /= maxNumberOfMuseums;
        return result;
    }

    const int maxNumberOfMuseums = 5;
    MuseumResult museums;
    Vector<double> distances;
}

class PetClinicsResult;
class PetParksResult;

public class PetTerm extends Term {
    public PetTerm(Coordinates coords, double radius, PetClinicsResult petClinics, PetParksResult petParks) {
        this.coords = coords;
        this.petClinics = petClinics;
        this.petParks = petParks;
        this.radius = radius;

        parkDistances = new Vector<double>();
        for(int i = 0; i < petParks.count; i++) {
            double distance = Utils.distance(coords, new Coordinates(petParks.data.data[i].place.coordinates[0], petParks.data.data[i].place.coordinates[1]));
            if(distance <= radius)
                parkDistances.add(Utils.distFunction(distance));
        }
    }

    @Override
    public double calculate() {
        double result = 0;
        for(double distance : parkDistances) {
            result += distance;
        }
        result /= 2 * parkDistances.size();
        result += petClinics.count / maxClinics;
        result /= 3;
        return result;
    }

    const int maxClinics = 3;

    PetClinicsResult petClinics;
    PetParksResult petParks;

    Vector<double> parkDistances;
}

class RecyclingResult;

public class RecyclingTerm extends Term {
    public RecyclingTerm(Coordinates coords, double radius, RecyclingResult recycling) {
        this.coords = coords;
        this.recycling = recycling;
        this.radius = radius;

        for(result : recycling.results) {
            Vector<double> distances = new Vector<double>();
            for(object : result.objects) {
                distances.add(Utils.distance(coords, new Coordinates(object.geometry.coordinates[0], object.geometry.coordinates[1])));
            }
            weights.put(Utils.distFunction(Collections.min(distances))) = ;
        }
    }

    @Override
    public double calculate() {
        double result = 0;
        for(Pair<String, Double> category : weights) {
            result += category.value;
        }
        result /= categoriesCount;
        return result;
    }

    const int categoriesCount = 10;
    HashMap<String, double> weights;
    RecyclingResult recycling;
}

class RestaurantResult;

public class RestaurantTerm extends Term {
    public RestaurantTerm(Coordinates coords, double radius, RestaurantResult restaurants) {
        this.coords = coords;
        this.restaurants = restaurants;
        this.radius = radius;

        distances = new Vector<double>();
        for(int i = 0; i < restaurants.count; i++) {
            double distance = Utils.distance(coords, new Coordinates(restaurants.results[i].coord[0], restaurants.data[i].coord[1]));
            if(distance <= radius)
                distances.add(Utils.distFunction(distance));
        }
    }

    @Override
    public double calculate() {
        double result = 0;
        for(double distance : distances) {
            result += Utils.distFunction(distance);
        }
        result /= maxRestaurants;
        return result;
    }

    const int maxRestaurants = 15;
    RestaurantResult restaurants;
    Vector<double> distances;
}

class SchoolResult;

public class SchoolTerm extends Term {
    public SchoolTerm(Coordinates coords, double radius, SchoolResult schools) {
        this.coords = coords;
        this.schools = schools;
        this.radius = radius;

        distances = new Vector<double>();
        for(int i = 0; i < restaurants.count; i++) {
            double distance = Utils.distance(coords, new Coordinates(restaurants.results[i].coord[0], restaurants.data[i].coord[1]));
            if(distance <= radius)
                distances.add(Utils.distFunction(distance));
        }
    }

    @Override
    public double calculate() {
       return 1;
    }

    Vector<double> distances;
    SchoolResult schools;
}

class SportgroundResult;

public class SportgroundTerm extends Term {

    public SportgroundTerm(Coordinates coordinates, double radius, SportgroundResult sportgrounds) {
        this.coordinates = coordinates;
        this.sportgrounds = sportgrounds;
        sportgrounds = sportgroundsList;
        importantSports = new HashSet<String>("Футбол", "Настольный теннис", "Баскетбол");

        for(int i = 0; i < sportgrounds.size(); i++) {
            String[] sports = sportgrounds[i].sports.split(",");
            for(String sport : sports) {
                double weight = importantSports.contains(sport) ? 2 : 1;
                weights.put(sport, weight);
            }
        }
    }

    @Override
    public double calculate() {
        double result = 0;
        for (Pair<String, Double> sport : weights) {
            result += Utils.distFunction(Sportground.distance) * sport.value;
        }
        result /= weights.size();
        return result;
    }

    SportgroundResult sportgrounds;
    private HashSet<String> importantSports;
    HashMap<String, double> weights;
}

class TheatreResult;

public class TheatreTerm extends Term {
    public TheatreTerm(Coordinates coords, double radius, TheatreResult theatres) {
        this.coords = coords;
        this.theatres = theatres;
        this.radius = radius;

        distances = new Vector<double>();
        for(int i = 0; i < museums.count; i++) {
            double distance = Utils.distance(coords, new Coordinates(theatres.data[i].coord[0], museums.data[i].coord[1]));
            if(distance <= radius)
                distances.add(distance);
        }
    }

    @Override
    public double calculate() {
        double result = 0;
        for(int i = 0; i < distances.size() && i < maxNumberOfTheatres; i++) {
            result += Utils.distFunction(distances[i]);
        }
        result /= maxNumberOfTheatres;
        return result;
    }

    const int maxNumberOfTheatres = 15;
    Vector<double> distances;
    TheatreResult theatres;
}

class TransportResult;

public class TransportTerm extends Term {
    public TransportTerm(Coordinates coords, double radius, TransportResult transports) {
        this.coords = coords;
        this.transports = transports;
        this.radius = radius;

        routes = new HashSet<String>();
        for(result : transports.result)
            routes.add(result.routeId);
    }

    @Override
    public double calculate() {
        if(routes.size() > 7) return 1;
        return Utils.logWithOffset(routes.size(), 1.3, 0.96);
    }

    HashSet<String> routes;
    TransportTerm transports;
}

class OurPetersburgResult;

public class OurPetersburgTerm extends Term {
    public OurPetersburgTerm(OurPetersburgResult ourPetersburg) {
        this.ourPetersburg = ourPetersburg;
    }

    @Override
    public double calculate() {
        double score = 0;
        for (problem : ourPetersburg.problems)
        {
            if (problem.is_closed == 0)
                score -= 1;
            else
            {
                if (listMinuses.contains(problem.type()))
                    score+=0.5;
                else if (listEquals.contains(problem.type()))
                    score+=0.75;
                else if (listPluses.contains(problem.type()))
                    score+=1;
            }
        }
        return score/problems.count();
    }
    private OurPetersburgResult ourPetersburg;
}
