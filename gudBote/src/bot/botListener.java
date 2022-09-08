package bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;
import net.dv8tion.jda.api.entities.VoiceChannel;


public class botListener extends ListenerAdapter {

    private static String icon = ("https://i0.wp.com/m1.behance.net/rendition/modules/94328067/disp/a3a9b5d7bc091ca0c8e3eb41442aadbe.png");


    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String messArgs[] = event.getMessage().getContentRaw().split("\\s+");
        String command = "";
        try{

            if(messArgs[0].equals(Bot.prefix)){
                command = messArgs[1];

            }
        }
        catch(Exception e){

        }
        System.out.print(command);
        if(command.equalsIgnoreCase("gudboy")){
            
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessageEmbeds(getEmbed(event)).queue();
            
        }
        if(command.equalsIgnoreCase( "rooting")){
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessageEmbeds(getEmbedRooting(event)).queue();
        }
        if(command.equalsIgnoreCase("meme")){
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessageEmbeds(getEmbedMeme(event)).queue();
        }
        if(command.equalsIgnoreCase( "info")){
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessageEmbeds(getEmbedInfo(event)).queue();
        }
        if(command.equalsIgnoreCase( "racist")){
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessageEmbeds(getEmbedRacist(event)).queue();
        }
        if(command.equalsIgnoreCase("quote")){
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessageEmbeds(getEmbedQuote(event)).queue();
        }
        if(command.equalsIgnoreCase("synonyms")){
            String word = "";
            try{
                word = messArgs[2];
            }
            catch(Exception e){
                event.getChannel().sendMessage("Learn to use the commands dumb bot.").queue();
            }
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessageEmbeds(getEmbedSynonyms(event, word)).queue();
        }
        if(command.equalsIgnoreCase("sovietcap")){
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessageEmbeds(getEmbedSoviet(event)).queue();
        }
        if(command.equalsIgnoreCase("audio")){
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(joinVoiceChannel(event)).queue();
        }

        if(shh(event.getMember().getUser().getName())){
            event.getChannel().sendMessageEmbeds(getShutUpEmbed(event)).queue();
        }
        
        

    }
    public boolean shh(String user){
        targetUser userClass = new targetUser();
        return (userClass.isTargetUser(user));
    }
    private MessageEmbed getEmbed(GuildMessageReceivedEvent thisevent){
        EmbedBuilder info = new EmbedBuilder();
        info.setTitle("😎😎😎😎Gud Bote");
        info.setDescription("I am a gud bote end I do nothing.");
        info.addField(thisevent.getMember().getUser().getName(),"Hello!!",true);
        info.setFooter("anakin5kywalker", icon);
        info.setColor(0x0F9D58);
        MessageEmbed embed = info.build();
        info.clear();
        return embed;
    }
    private MessageEmbed getEmbedRooting(GuildMessageReceivedEvent thisevent){
        EmbedBuilder info = new EmbedBuilder();
        info.setTitle("😎😎😎😎Gud Bote Tells Rooting");
        info.setDescription("I dont know class rooting now lol");
        info.addField(thisevent.getMember().getUser().getName(),"",true);
        info.setFooter("gud bot", icon);
        info.setColor(0x0F9D58);
        MessageEmbed embed = info.build();
        info.clear();
        return embed;
    }
    private static MessageEmbed getEmbedMeme(GuildMessageReceivedEvent thisevent){
        EmbedBuilder info = new EmbedBuilder();
        info.setTitle("😎😎😎😎Gud Bote sands meme");
        info.setDescription("See meme");
        info.addField(thisevent.getMember().getUser().getName(),"",true);
        info.setImage(getMemeUrl());
        info.setFooter("gud bot", icon);
        info.setColor(0x0F9D58);
        MessageEmbed embed = info.build();
        info.clear();
        return embed;
    }
    private static MessageEmbed getEmbedRacist(GuildMessageReceivedEvent thisevent){
        EmbedBuilder info = new EmbedBuilder();
        info.setTitle(thisevent.getMember().getUser().getName() + "is Racist");
        info.setDescription("I am Recist");
        info.addField(thisevent.getMember().getUser().getName(),"The Racist",true);
        info.setFooter("gud bot", icon);
        info.setColor(0x0F9D58);
        MessageEmbed embed = info.build();
        info.clear();
        return embed;
    }
    private static MessageEmbed getEmbedQuote(GuildMessageReceivedEvent thisevent){
        EmbedBuilder info = new EmbedBuilder();
        info.setTitle("🤔🤔🤔🤔Quote");
        info.setDescription(getQuote());
        info.addField(thisevent.getMember().getUser().getName(),"",true);
        info.setFooter("gud bot", icon);
        info.setColor(0x0F9D58);
        MessageEmbed embed = info.build();
        info.clear();
        return embed;
    }
    private static MessageEmbed getEmbedSynonyms(GuildMessageReceivedEvent thisevent, String word){
        EmbedBuilder info = new EmbedBuilder();
        info.setTitle("Synonyms of " + word );
        info.setDescription(getSynonyms(word));
        info.addField(thisevent.getMember().getUser().getName(),"",true);
        info.setFooter("gud bot", icon);
        info.setColor(0x0F9D58);
        MessageEmbed embed = info.build();
        info.clear();
        return embed;
    }
    private static String getMemeUrl(){
        getMeme gMeme = new getMeme();
        String memeUrl = " ";
        try{
            memeUrl = getMeme.call_me().toString();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return memeUrl;
    }
    private static String getQuote(){
        getQuote gQuote = new getQuote();
        String quoteText = " ";
        try{
            quoteText = getQuote.call_me().toString();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return quoteText;
    }
    private static String getSynonyms(String word){
        getMeaning gMeaning = new getMeaning();
        String SynonymText = " ";
        try{
            SynonymText = getMeaning.call_me(word).toString();
        }
        catch(Exception e){
            e.printStackTrace();
            return(e.toString());
        }
        return SynonymText;
        
    }
    private static MessageEmbed getShutUpEmbed(GuildMessageReceivedEvent thisevent){
        EmbedBuilder info = new EmbedBuilder();
        info.setTitle("😎😎😎😎Shut Up"+" "+ thisevent.getMember().getUser().getName());
        info.setDescription("Shut UPpppp");
        info.addField("Yours faithfully", "anakin",true);
        info.setImage("https://thumbs.dreamstime.com/b/asian-kid-girl-pink-sweater-shows-shhh-quiet-sign-background-137245275.jpg");
        info.setFooter("gud bot", icon);
        info.setColor(0x0F9D58);
        MessageEmbed embed = info.build();
        info.clear();
        return embed;
    }
    private static MessageEmbed getEmbedSoviet(GuildMessageReceivedEvent thisevent){
        EmbedBuilder info = new EmbedBuilder();
        info.setTitle("Mother Russia"+"🙋🏼🙋🏼🙋🏼🙋🏼 "+ "Vlad "+ thisevent.getMember().getUser().getName()+ " Travolsky");
        info.setImage("https://www.kindpng.com/picc/m/204-2044901_soviet-hat-png-transparent-png.png");
        info.setFooter("gud bot", icon);
        info.setColor(0x0F9D58);
        MessageEmbed embed = info.build();
        info.clear();
        return embed;
    }
    private static MessageEmbed getEmbedInfo(GuildMessageReceivedEvent thisevent){
        String channelMembers = " ";
        EmbedBuilder info = new EmbedBuilder();
        info.setTitle("🤓🤓🤓🤓 info");
        for(int i = 0 ; i < thisevent.getChannel().getMembers().size(); i++){
            System.out.print(thisevent.getChannel().getMembers().get(i));
            channelMembers = thisevent.getChannel().getMembers().get(i).toString() + " " + channelMembers;
        }
        info.setDescription(channelMembers);
        info.setFooter("gud bot", icon);
        info.setColor(0x0F9D58);
        MessageEmbed embed = info.build();
        info.clear();
        return embed;
    }

    private static Message joinVoiceChannel(GuildMessageReceivedEvent thisEvent){
        VoiceChannel connectedChannel = thisEvent.getMember().getVoiceState().getChannel();
        MessageBuilder builder = new MessageBuilder();
        AudioManager manager = thisEvent.getGuild().getAudioManager();
        if(!(connectedChannel == null)){
            manager.openAudioConnection(connectedChannel);
            if(manager.isConnected()){
                builder.append("Bot has connected");
            }
        }
        else{
            builder.append("@"+thisEvent.getMember() + ", Join a channel");
        }
        Message message = builder.build();
        return message;

    }


    
    
}
