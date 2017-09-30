package appSearch

import utilities.UtilityHelper

class MTFlightFinder{
    Boolean FlightFinder_img_exists(){
      def  rtn = UtilityHelper.findImageBySrc("/images/masts/mast_flightfinder.gif")
        return rtn
    }
}

