package com.example.android.gds_newsapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by alanionita on 02/07/2018.
 */

public final class QueryUtils {
    private static final String JSON_DATA = "{\"response\":{\"status\":\"ok\",\"userTier\":\"developer\",\"total\":25227,\"startIndex\":1,\"pageSize\":10,\"currentPage\":1,\"pages\":2523,\"orderBy\":\"relevance\",\"results\":[" +
            "{\"id\":\"politics/2018/may/29/should-labour-oppose-brexit\",\"type\":\"article\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2018-05-29T17:23:29Z\",\"webTitle\":\"Should Labour oppose Brexit? | Letters\",\"webUrl\":\"https://www.theguardian.com/politics/2018/may/29/should-labour-oppose-brexit\",\"apiUrl\":\"https://content.guardianapis.com/politics/2018/may/29/should-labour-oppose-brexit\",\"tags\":[],\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"}," +
            "{\"id\":\"politics/commentisfree/2018/apr/13/expats-rights-after-brexit\",\"type\":\"article\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2018-04-13T15:25:42Z\",\"webTitle\":\"Expats’ rights after Brexit | Letters\",\"webUrl\":\"https://www.theguardian.com/politics/commentisfree/2018/apr/13/expats-rights-after-brexit\",\"apiUrl\":\"https://content.guardianapis.com/politics/commentisfree/2018/apr/13/expats-rights-after-brexit\",\"tags\":[],\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"}," +
            "{\"id\":\"politics/2018/apr/03/brexit-weekly-briefing-less-than-a-year-to-brexit-day\",\"type\":\"article\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2018-04-03T05:00:08Z\",\"webTitle\":\"Brexit weekly briefing: less than a year to Brexit day\",\"webUrl\":\"https://www.theguardian.com/politics/2018/apr/03/brexit-weekly-briefing-less-than-a-year-to-brexit-day\",\"apiUrl\":\"https://content.guardianapis.com/politics/2018/apr/03/brexit-weekly-briefing-less-than-a-year-to-brexit-day\",\"tags\":[{\"id\":\"profile/jonhenley\",\"type\":\"contributor\",\"webTitle\":\"Jon Henley\",\"webUrl\":\"https://www.theguardian.com/profile/jonhenley\",\"apiUrl\":\"https://content.guardianapis.com/profile/jonhenley\",\"references\":[],\"bio\":\"<p>Jon Henley is the Guardian's European affairs correspondent. He was previously a foreign correspondent most recently in Paris, where he was the paper's bureau chief for nearly a decade, and senior feature writer.&nbsp;</p>\",\"bylineImageUrl\":\"https://uploads.guim.co.uk/2016/09/22/Jon-Henley.jpg\",\"bylineLargeImageUrl\":\"https://uploads.guim.co.uk/2017/10/06/Jon_Henley,_L.png\",\"firstName\":\"henley\",\"lastName\":\"\",\"twitterHandle\":\"jonhenley\"}],\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"}," +
            "{\"id\":\"politics/2018/jun/28/womens-rights-at-risk-after-brexit\",\"type\":\"article\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2018-06-28T17:16:20Z\",\"webTitle\":\"Women’s rights at risk after Brexit | Letters\",\"webUrl\":\"https://www.theguardian.com/politics/2018/jun/28/womens-rights-at-risk-after-brexit\",\"apiUrl\":\"https://content.guardianapis.com/politics/2018/jun/28/womens-rights-at-risk-after-brexit\",\"tags\":[],\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"}," +
            "{\"id\":\"politics/2018/jun/23/brexit-demonstration-whitehall-demand-second-referendum\",\"type\":\"article\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2018-06-23T19:22:47Z\",\"webTitle\":\"Huge anti-Brexit demonstration throngs central London\",\"webUrl\":\"https://www.theguardian.com/politics/2018/jun/23/brexit-demonstration-whitehall-demand-second-referendum\",\"apiUrl\":\"https://content.guardianapis.com/politics/2018/jun/23/brexit-demonstration-whitehall-demand-second-referendum\",\"tags\":[{\"id\":\"profile/michael-savage\",\"type\":\"contributor\",\"webTitle\":\"Michael Savage\",\"webUrl\":\"https://www.theguardian.com/profile/michael-savage\",\"apiUrl\":\"https://content.guardianapis.com/profile/michael-savage\",\"references\":[],\"bylineImageUrl\":\"https://uploads.guim.co.uk/2018/02/19/Michael-Savage.jpg\",\"bylineLargeImageUrl\":\"https://uploads.guim.co.uk/2018/02/18/Michael-Savage,-L.png\",\"firstName\":\"Michael\",\"lastName\":\"Savage\"}," +
            "{\"id\":\"profile/emma-graham-harrison\",\"type\":\"contributor\",\"webTitle\":\"Emma Graham-Harrison\",\"webUrl\":\"https://www.theguardian.com/profile/emma-graham-harrison\",\"apiUrl\":\"https://content.guardianapis.com/profile/emma-graham-harrison\",\"references\":[],\"bylineImageUrl\":\"https://uploads.guim.co.uk/2018/01/14/Emma-Graham-Harrison.jpg\",\"bylineLargeImageUrl\":\"https://uploads.guim.co.uk/2018/01/14/Emma_Graham-Harrison,_L.png\",\"firstName\":\"Emma\",\"lastName\":\"Graham-Harrison\"}],\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"}," +
            "{\"id\":\"politics/2018/jun/22/working-class-concerns-ignored-in-brexit-debate\",\"type\":\"article\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2018-06-22T15:45:21Z\",\"webTitle\":\"Working-class concerns ignored in Brexit debate | Letters\",\"webUrl\":\"https://www.theguardian.com/politics/2018/jun/22/working-class-concerns-ignored-in-brexit-debate\",\"apiUrl\":\"https://content.guardianapis.com/politics/2018/jun/22/working-class-concerns-ignored-in-brexit-debate\",\"tags\":[],\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"}," +
            "{\"id\":\"world/2018/jun/19/tuesday-briefing-peers-unravel-brexit-stitch-up\",\"type\":\"article\",\"sectionId\":\"world\",\"sectionName\":\"World news\",\"webPublicationDate\":\"2018-06-19T05:24:48Z\",\"webTitle\":\"Tuesday briefing: Peers unravel Brexit stitch-up\",\"webUrl\":\"https://www.theguardian.com/world/2018/jun/19/tuesday-briefing-peers-unravel-brexit-stitch-up\",\"apiUrl\":\"https://content.guardianapis.com/world/2018/jun/19/tuesday-briefing-peers-unravel-brexit-stitch-up\",\"tags\":[{\"id\":\"profile/warrenmurray\",\"type\":\"contributor\",\"webTitle\":\"Warren Murray\",\"webUrl\":\"https://www.theguardian.com/profile/warrenmurray\",\"apiUrl\":\"https://content.guardianapis.com/profile/warrenmurray\",\"references\":[],\"bio\":\"<p>Warren Murray is the Guardian's UK/US site editor in the Asia-Pacific timezone. He has worked for the Guardian in London as well as ABC News Online, the Irish Independent group in Dublin and capital-city newspapers in Canada. He is based in Queensland.</p>\",\"bylineImageUrl\":\"https://static.guim.co.uk/sys-images/Guardian/Pix/pictures/2015/5/12/1431395081916/Warren_Murray_140x140.jpg\",\"bylineLargeImageUrl\":\"https://uploads.guim.co.uk/2017/11/29/Warren_Murray_L.png\",\"firstName\":\"murray\",\"lastName\":\"warren\"}],\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"politics/2018/jun/17/inflammatory-language-amid-the-battle-of-brexit\",\"type\":\"article\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2018-06-17T16:56:13Z\",\"webTitle\":\"Inflammatory language amid the battle of Brexit | Letters\",\"webUrl\":\"https://www.theguardian.com/politics/2018/jun/17/inflammatory-language-amid-the-battle-of-brexit\",\"apiUrl\":\"https://content.guardianapis.com/politics/2018/jun/17/inflammatory-language-amid-the-battle-of-brexit\",\"tags\":[],\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"}," +
            "{\"id\":\"uk-news/2018/jun/16/arron-banks-nigel-farage-leave-brexit-russia-connection\",\"type\":\"article\",\"sectionId\":\"uk-news\",\"sectionName\":\"UK news\",\"webPublicationDate\":\"2018-06-16T20:30:07Z\",\"webTitle\":\"Arron Banks, Brexit and the Russia connection\",\"webUrl\":\"https://www.theguardian.com/uk-news/2018/jun/16/arron-banks-nigel-farage-leave-brexit-russia-connection\",\"apiUrl\":\"https://content.guardianapis.com/uk-news/2018/jun/16/arron-banks-nigel-farage-leave-brexit-russia-connection\",\"tags\":[{\"id\":\"profile/carolecadwalladr\",\"type\":\"contributor\",\"webTitle\":\"Carole Cadwalladr\",\"webUrl\":\"https://www.theguardian.com/profile/carolecadwalladr\",\"apiUrl\":\"https://content.guardianapis.com/profile/carolecadwalladr\",\"references\":[],\"bio\":\"<p>Carole Cadwalladr grew up in Wales and is a reporter and feature writer for the Observer.&nbsp;</p>\",\"bylineImageUrl\":\"https://uploads.guim.co.uk/2018/03/21/Carole-Cadwalladr.jpg\",\"bylineLargeImageUrl\":\"https://uploads.guim.co.uk/2018/03/21/Carole_Cadwalladr,_L.png\",\"firstName\":\"Carole\",\"lastName\":\"Cadwalladr\",\"twitterHandle\":\"carolecadwalla\"}],\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"}," +
            "{\"id\":\"politics/2018/jun/12/brexit-withdrawal-bill-negotiations-rebels-meaningful-vote\",\"type\":\"article\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2018-06-12T13:41:59Z\",\"webTitle\":\"Brexit bill negotiations enter frantic final hours\",\"webUrl\":\"https://www.theguardian.com/politics/2018/jun/12/brexit-withdrawal-bill-negotiations-rebels-meaningful-vote\",\"apiUrl\":\"https://content.guardianapis.com/politics/2018/jun/12/brexit-withdrawal-bill-negotiations-rebels-meaningful-vote\",\"tags\":[{\"id\":\"profile/jessica-elgot\",\"type\":\"contributor\",\"webTitle\":\"Jessica Elgot\",\"webUrl\":\"https://www.theguardian.com/profile/jessica-elgot\",\"apiUrl\":\"https://content.guardianapis.com/profile/jessica-elgot\",\"references\":[],\"bio\":\"<p>Jessica Elgot is a Guardian political correspondent. Twitter:&nbsp;<a href=\\\"https://twitter.com/jessicaelgot\\\">@jessicaelgot</a></p>\",\"bylineImageUrl\":\"https://static.guim.co.uk/sys-images/Guardian/Pix/contributor/2015/6/26/1435313697913/Jessica-Elgot.jpg\",\"bylineLargeImageUrl\":\"https://uploads.guim.co.uk/2017/10/06/Jessica-Elgot,-R.png\",\"firstName\":\"Jessica\",\"lastName\":\"Elgot\",\"twitterHandle\":\"jessicaelgot\"}," + "{\"id\":\"profile/pippacrerar\",\"type\":\"contributor\",\"webTitle\":\"Pippa Crerar\",\"webUrl\":\"https://www.theguardian.com/profile/pippacrerar\",\"apiUrl\":\"https://content.guardianapis.com/profile/pippacrerar\",\"references\":[],\"bylineImageUrl\":\"https://uploads.guim.co.uk/2018/05/08/Pippa-Crerar.jpg\",\"bylineLargeImageUrl\":\"https://uploads.guim.co.uk/2018/05/08/Pippa_Crerar,_L.png\",\"firstName\":\"Pippa\",\"lastName\":\"Crerar\"}],\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"}]}}";

    public static ArrayList<Story> extractStories () {
        ArrayList<Story> storiesHolder = new ArrayList<>();

        try{
            JSONObject readJSON = new JSONObject(JSON_DATA);
            JSONObject response = readJSON.getJSONObject("response");
            JSONArray results = response.getJSONArray("results");
            Log.i("results length", Integer.toString(results.length()));
            for (int i = 0; i < results.length(); i++) {
                JSONObject storyElem = (JSONObject) results.get(i);
                String webTitle = storyElem.getString("webTitle");
                String sectionName = storyElem.getString("sectionName");
                String webPublicationDate = storyElem.getString("webPublicationDate");
                String webUrl = storyElem.getString("webUrl");
                JSONArray tags = storyElem.getJSONArray("tags");
                ArrayList<String> authors = new ArrayList<>();

                // Finds authors if tag object is present
                if(tags.length() > 0) {
                    for(int j = 0; j < tags.length(); j++){
                        JSONObject individualTag = (JSONObject) tags.get(j);
                        String author = individualTag.getString("webTitle");
                        authors.add(author);
                    }
                }

                // Parse the data into Story objects
                Story parsedStory = new Story(webTitle, sectionName, webUrl,
                        authors, webPublicationDate);
                // Add to storiesHolder
                storiesHolder.add(parsedStory);
            }


        } catch (JSONException e){
            Log.e("QueryUtils", "Error while parsing JSON data", e);
        }
        return storiesHolder;
    };
}
