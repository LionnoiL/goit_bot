package ua.dpw.telegrambots.currencybot.messages;

import lombok.Data;

@Data
public class Message {

    private String header = "";
    private String headerDelimiter = "";
    private String body = "";
    private String bodyDelimiter = "";
    private String footer = "";
    private String footerDelimiter = "";
    private String info = "";


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (!header.isEmpty()){
            sb.append(header);
            if(!headerDelimiter.isEmpty()){
                sb.append(headerDelimiter);
            }
        }

        if (!body.isEmpty()){
            sb.append(body);
            if(!bodyDelimiter.isEmpty()){
                sb.append(bodyDelimiter);
            }
        }

        if (!footer.isEmpty()){
            sb.append(footer);
            if(!footerDelimiter.isEmpty()){
                sb.append(footerDelimiter);
            }
        }

        return sb.toString();
    }

    public boolean isEmpty(){
        return toString().isEmpty();
    }
}
